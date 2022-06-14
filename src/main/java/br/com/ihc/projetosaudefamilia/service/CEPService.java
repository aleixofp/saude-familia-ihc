package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CEPService {

    @Autowired
    private OkHttpClient client;

    public EnderecoVO consultarCEP(String cep) throws IOException {
        Request request = new Request.Builder()
                .url(String.format("https://viacep.com.br/ws/%s/json/", cep.replaceAll("-", "")))
                .build();

        Response response = this.client.newCall(request).execute();
        return new Gson().fromJson(response.body().string(), EnderecoVO.class);
    }

}
