package com.MTGAPI.magic.card;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardController.class)
class CardControllerIntegrationTest {

    @MockBean
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setupMockMvc() {

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void shouldCreateMockMvc() {

        assertNotNull(mockMvc);
    }

    @Test
    void testGetAllCardsWhenValid () throws Exception {
        when(cardService.getAllCards()).thenReturn(
                List.of(new Card("test", 10, "U", "test", "t", 10, 10)));
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/cards"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]name", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]cmc", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]mana_type", Matchers.is("U")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]type_line", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]expansion", Matchers.is("t")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]power", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]toughness", Matchers.is(10)))
                .andReturn();
        verify(cardService).getAllCards();
    }

    @Test
    public void testReturnsNotFoundForInvalidCard () throws Exception {
        when(cardService.find(999L)).thenReturn(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/cards/999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void testFindCard() throws Exception {
        when(cardService.find(1L)).thenReturn(
                new Card(1L,"test", 10, "U", "test", "t", 10, 10));
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/cards/1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                        .andReturn();
        verify(cardService).find(1L);
    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testAddNewCardWhenValid() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(asJsonString(new Card("test", 5
                                , "T", "t", "t"
                                , 5,5)))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        verify(cardService).createNewCard(any(CardCreatePayload.class));
    }

    @Test
    void testUpdateCard() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.patch("/api/cards/1")
                        .content(asJsonString(new Card(1L, "test", 5
                                , "T", "t", "t"
                                , 5,5)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testDeleteCard() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/cards/1"))
                .andExpect(status().isOk());
        verify(cardService).delete(1L);
    }
}