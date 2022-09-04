package com.licenta.auth.payload.response;


public class GetUsersResponse {
    private String nume;
    private String prenume;

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public GetUsersResponse(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }
}
