
package br.com.supply.rest.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.supply.rest.model.Supply;

@ManagedBean
@SessionScoped
public class SupplyBean{

	private Supply abastecimento = new Supply();
	private List<Supply> abastecimentos;
	private final Client c = Client.create();
	private final Gson gson = new Gson();
	
	private static final String URL = "https://openws.herokuapp.com/abastecimentos";   
    private static final String TOLKEN = "?apiKey=467fdbb1d0b6ff5c541406c9da7068a9";

    public SupplyBean() {
        recarregar();
    }

   	@SuppressWarnings("serial")
	public void recarregar() {   		
        WebResource wr = c.resource(URL + TOLKEN);
        String json = wr.get(String.class);
        abastecimentos = gson.fromJson(json, new TypeToken<List<Supply>>() {
        }.getType());
    }

    public String novo() {
        this.abastecimento = new Supply();
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
        abastecimento = new Supply();
        recarregar();
        return "index";
    }

    public void remover(Supply obj) {
        WebResource wr = c.resource(URL + "/" + obj.getId() + TOLKEN);
        wr.delete();
        recarregar();
    }
    
    
    public void editar(Supply obj) {      
        this.abastecimento = obj;
    }

    public Supply getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(Supply abastecimento) {
        this.abastecimento = abastecimento;
    }

    public List<Supply> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Supply> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }   
    
}
