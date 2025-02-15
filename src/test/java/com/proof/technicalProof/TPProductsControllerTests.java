package com.proof.technicalProof;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TPProductsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * To probe the method obtainAllProducts - the size expected is 4
     * @throws Exception
     */
    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/api/products/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray()) // Verifica que la respuesta es un arreglo
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(4))); // Verifica el tamaño del arreglo, ajusta el número según tus expectativas
                
    }
    
    /**
     * To probe the method findByBrandIdAndProductIdAndStartDate
     *  Data for this test:
     *     - Brand_id: 1
     *     - Product_id: 35455
     *     - Date: 2020-06-14T10:00:00
     * @throws Exception
     */
    @Test
    void testFindByBrandIdAndProductIdAndApplyDate_1() throws Exception {
        mockMvc.perform(get("/api/products/findByBrandIdAndProductIdAndStartDate/1/35455/2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray()) // Verifica que la respuesta es un arreglo
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(3))) // Verifica el tamaño del arreglo, ajusta el número según tus expectativas
                .andExpect(jsonPath("$[0].price").value(25.45)) // Verifica el nombre de la primera entidad
                .andExpect(jsonPath("$[1].price").value(30.50)) // Verifica el nombre de la segunda entidad
                .andExpect(jsonPath("$[2].price").value(38.95));                
    }
    
    /**
     * To probe the method findByBrandIdAndProductIdAndStartDate
     *  Data for this test:
     *     - Brand_id: 1
     *     - Product_id: 35455
     *     - Date: 2020-06-14T16:00:00
     * @throws Exception
     */
    @Test
    void testFindByBrandIdAndProductIdAndApplyDate_2() throws Exception {
        mockMvc.perform(get("/api/products/findByBrandIdAndProductIdAndStartDate/1/35455/2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray()) // Verifica que la respuesta es un arreglo
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(2))) // Verifica el tamaño del arreglo, ajusta el número según tus expectativas
                .andExpect(jsonPath("$[0].price").value(30.50)) // Verifica el nombre de la segunda entidad
                .andExpect(jsonPath("$[1].price").value(38.95));                
    }
    
    /**
     * To probe the method findByBrandIdAndProductIdAndStartDate
     *  Data for this test:
     *     - Brand_id: 1
     *     - Product_id: 35455
     *     - Date: 2020-06-14T21:00:00
     * @throws Exception
     */
    @Test
    void testFindByBrandIdAndProductIdAndApplyDate_3() throws Exception {
        mockMvc.perform(get("/api/products/findByBrandIdAndProductIdAndStartDate/1/35455/2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray()) // Verifica que la respuesta es un arreglo
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(2))) // Verifica el tamaño del arreglo, ajusta el número según tus expectativas
                .andExpect(jsonPath("$[0].price").value(30.50)) // Verifica el nombre de la segunda entidad
                .andExpect(jsonPath("$[1].price").value(38.95));                
    }
    
    /**
     * To probe the method findByBrandIdAndProductIdAndStartDate
     *  Data for this test:
     *     - Brand_id: 1
     *     - Product_id: 35455
     *     - Date: 2020-06-15T10:00:00
     * @throws Exception
     */
    @Test
    void testFindByBrandIdAndProductIdAndApplyDate_4() throws Exception {
        mockMvc.perform(get("/api/products/findByBrandIdAndProductIdAndStartDate/1/35455/2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray()) // Verifica que la respuesta es un arreglo
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(1))) // Verifica el tamaño del arreglo, ajusta el número según tus expectativas
                .andExpect(jsonPath("$[0].price").value(38.95));                
    }
    
    /**
     * To probe the method findByBrandIdAndProductIdAndStartDate
     *  Data for this test:
     *     - Brand_id: 1
     *     - Product_id: 35455
     *     - Date: 2020-06-16T21:00:00
     * @throws Exception
     */
    @Test
    void testFindByBrandIdAndProductIdAndApplyDate_5() throws Exception {
        mockMvc.perform(get("/api/products/findByBrandIdAndProductIdAndStartDate/1/35455/2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray()) // Verifica que la respuesta es un arreglo
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(0))); // Verifica el tamaño del arreglo, ajusta el número según tus expectativas
    }
}