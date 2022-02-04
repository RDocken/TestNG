package main.java;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;

public class TestCases {

        @Test(groups = {"IMDB" , "Positive"})
        /*d
        * Area: IMDB Api call using OKHTTP
        * Desc: Call to IMDB for Bio of Jason Bateman
        * Expect a 200 code with OK message
        *
        *  */
        public void IMDBJasonBatemenBio() throws IOException {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://imdb8.p.rapidapi.com/actors/get-bio?nconst=nm0000867")
                    .get()
                    .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0ee6e878e62bp1be385jsn24c75e23f3f9")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response " + response);
            assert(response.code() == 200);
            assert(response.message().equals("OK"));
        }

        @Test(groups = {"IMDB" , "Positive"})
        /*
         * Area: IMDB Api call using OKHTTP
         * Desc: Call to IMDB with information about The Ozarks
         * Expect a 200 code with OK message
         *
         *  */
        public void IMDBTheOzarks() throws IOException {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://imdb8.p.rapidapi.com/auto-complete?q=The%20Ozarks")
                    .get()
                    .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0ee6e878e62bp1be385jsn24c75e23f3f9")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response " + response);
            assert(response.code() == 200);
            assert(response.message().equals("OK"));
        }

        //wrong message
        @Test(groups = {"IMDB" , "Forbidden"})
        /*
         * Area: IMDB Api call using OKHTTP
         * Desc: Call to IMDB with invalid key
         * Expect a 403 code with Forbidden message
         *
         *  */
        public void TestCase3() throws IOException {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://imdb8.p.rapidapi.com/actors/get-bio?nconst=81u1n")
                    .get()
                    .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0eeasdfasdfe878e62bp1be385jsn24c75e23f3f9")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response " + response);
            assert(response.code() == 403);
            assert(response.message().equals("Forbidden"));
        }

        @Test(groups = {"IMDB" , "Fail"})
        /*
         * Area: IMDB Api call using OKHTTP
         * Desc: Call to IMDB test fails
         * Expect: Test Failure
         *
         *  */
        public void IMDBFail() throws IOException {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://imdb8.p.rapidapi.com/actors/get-bio?nconst=81u1n")
                    .get()
                    .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0eeasdfasdfe878e62bp1be385jsn24c75e23f3f9")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response " + response);
            assert(response.code() == 200);
        }

        @Test(groups = {"COVID" , "Positive"})
        /*
         * Area: Covid API Call with OkHttp
         * Desc: Get US Covid data
         * Expect: code 200 and OK message
         *
         *  */
        public void CovidUSData() throws IOException {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://covid-19-data.p.rapidapi.com/country/code?code=us")
                    .get()
                    .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0ee6e878e62bp1be385jsn24c75e23f3f9")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("response: " + response);
//            assert(response.code() == 200);
    }

    @Test(groups = {"COVID" , "Positive"})
    /*
     * Area: Covid API call using OKHTTP
     * Desc: Get Totals Worldwide
     * Expect: code 200 and OK message
     *
     *  */
    public void CovidTotals() throws IOException{

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/totals")
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0ee6e878e62bp1be385jsn24c75e23f3f9")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println("Response " + response);
        assert(response.code() == 200);
    }

    @Test(groups = {"COVID" , "Forbidden"})
    /*
     * Area: Covid API Call with OkHttp
     * Desc: Calling Covid api with false key
     * Expect: Code 403 and Message Forbidden
     *
     *  */
    public void CovidForbidden() throws IOException{

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/totals")
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "6d06fe5799msh5aa0ee6e87asasdf;fnksfds8e62bp1be385jsn24c75e23f3f9")
                .build();

        Response response = client.newCall(request).execute();

    }



}
