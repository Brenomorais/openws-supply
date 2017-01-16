
package br.com.myabastecimentos.rest.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.myabastecimentos.rest.model.Abastecimento;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@ManagedBean
@SessionScoped
public class AbastecimentoBean{

	private Abastecimento abastecimento = new Abastecimento();
	private List<Abastecimento> abastecimentos;
	private final Client c = Client.create();
	private final Gson gson = new Gson();
	
	private static final String URL = "https://openws.herokuapp.com/abastecimentos";   
    private static final String TOLKEN = "?apiKey=467fdbb1d0b6ff5c541406c9da7068a9";

    public AbastecimentoBean() {
        recarregar();
    }

   	@SuppressWarnings("serial")
	public void recarregar() {   		
        WebResource wr = c.resource(URL + TOLKEN);
        String json = wr.get(String.class);
        abastecimentos = gson.fromJson(json, new TypeToken<List<Abastecimento>>() {
        }.getType());
    }

    public String novo() {
        this.abastecimento = new Abastecimento();
        return "index";
    }

    public String salvar() {
        if (abastecimento.getId() == null) {
            WebResource wr = c.resource(URL + TOLKEN);
            wr.type("application/json").accept("application/json")
              .post(gson.toJson(abastecimento));
        } else {
            WebResource wr = c.resource(URL + "/" + abastecimento.getId() 
              + TOLKEN);
            wr.type("application/json").accept("application/json")
              .put(gson.toJson(abastecimento));
        }
        abastecimento = new Abastecimento();
        recarregar();
        return "index";
    }

    public void remover(Abastecimento obj) {
        WebResource wr = c.resource(URL + "/" + obj.getId() + TOLKEN);
        wr.delete();
        recarregar();
    }
    
    
    public void editar(Abastecimento obj) {      
        this.abastecimento = obj;
    }

    public Abastecimento getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(Abastecimento abastecimento) {
        this.abastecimento = abastecimento;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }   
    
}
