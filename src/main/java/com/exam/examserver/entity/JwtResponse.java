package com.exam.examserver.entity;

public class JwtResponse {

    private String jwtToken;



    public JwtResponse() {
    }

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }



    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }


    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                '}';
    }

    public static class Builder {
        private String jwtToken;


        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }



        public JwtResponse build() {
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.jwtToken = this.jwtToken;

            return jwtResponse;
        }
    }

    // Builder method
    public static Builder builder() {
        return new Builder();
    }

}