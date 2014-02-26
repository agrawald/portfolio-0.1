package com.portfolio;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AppTests extends SpringTest {

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void about() throws Exception {
        mockMvc.perform(get("/about"))
                .andExpect(status().isOk())
                .andExpect(view().name("about"));
    }

    @Test
    public void contact() throws Exception {
        mockMvc.perform(get("/contact"))
                .andExpect(status().isOk())
                .andExpect(view().name("contact"));
    }

    @Test
    public void portfolio() throws Exception {
        mockMvc.perform(get("/portfolio"))
                .andExpect(status().isOk())
                .andExpect(view().name("portfolio"));
    }

    @Test
    public void testimonial() throws Exception {
        mockMvc.perform(get("/testimonial"))
                .andExpect(status().isOk())
                .andExpect(view().name("testimonial"));
    }

    @Override
    public void init() {

    }
}
