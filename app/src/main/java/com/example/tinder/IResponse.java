package com.example.tinder;

import java.util.List;

public interface IResponse {

    void onSuccess(List<Abonament> abonamentList);
    void onError(String message);

}
