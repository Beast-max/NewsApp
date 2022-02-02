import com.example.api.ApiClient
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ApiTest {
    @Test
    fun `get headline`(){
        val response = ApiClient.api.getheadline("2dac5c317ff84ae8866fc2738c747208","us").execute()
        assertNotNull(response.body())
    }
    @Test
    fun `get everything`(){
        val response = ApiClient.api.getEveryThing("2dac5c317ff84ae8866fc2738c747208","bitcoin").execute()
        assertNotNull(response.body())
    }
}