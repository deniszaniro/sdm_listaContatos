package br.edu.ifsp.sdm.denis.listacontatossdm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.sdm.denis.listacontatossdm.R;
import br.edu.ifsp.sdm.denis.listacontatossdm.adapter.ListaContatosAdapter;
import br.edu.ifsp.sdm.denis.listacontatossdm.model.Contato;

public class ListaContatosActivity extends AppCompatActivity {

    //referências para as views
    private ListView listaContatosListView;

    //lista de contatos usada para preencher a Listview
    private List<Contato> listaContatos;

    //adapter que preenche a ListView
    private ListaContatosAdapter listaContatosAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        listaContatosListView = findViewById(R.id.listaContatosListView);

        listaContatos = new ArrayList<>();

        preencheListaContatos();

        listaContatosAdapter = new ListaContatosAdapter(this, listaContatos);
        listaContatosListView.setAdapter(listaContatosAdapter);

        registerForContextMenu(listaContatosListView); //quando clicar no ListView, queremos que o menu de contexto apareça
    }

    private void preencheListaContatos() {
        for(int i = 0; i < 20; i++) {
            listaContatos.add(new Contato("C"+i, "IFSP", "123", "deniszaniro@yahoo"));
        }
    }

    //Para criar o menu normal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu); //estamos inflando o menu representado pelo nosso XML
        return true;
    }

    //Para tratar o evento de selecionar um item do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.configuracaoMenuItem:
                //carregar uma nova tela
                return true;
            case R.id.novoContatoMenuItem:
                //carregar uma nova tela
                return true;
            case R.id.sairMenuItem:
                finish();
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        Contato contato = listaContatos.get(menuInfo.position);

        switch(item.getItemId()) {
            case R.id.editarContatoMenuItem:
                //carregar uma nova tela
                return true;
            case R.id.ligarContatoMenuItem:
                //carregar uma nova tela
                return true;
            case R.id.verEnderecoMenuItem:
                //carregar uma nova tela
                return true;
            case R.id.enviarEmailMenuItem:
                //carregar uma nova tela
                return true;
            case R.id.removerContatoMenuItem:
                //carregar uma nova tela
                return true;
        }
        return false;
    }
}