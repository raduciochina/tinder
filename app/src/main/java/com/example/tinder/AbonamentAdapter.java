package com.example.tinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AbonamentAdapter extends BaseAdapter {

    private List<Abonament> listaAbonamente;

    public AbonamentAdapter(List<Abonament> listaAbonamente){
        this.listaAbonamente = listaAbonamente;
    }

    @Override
    public int getCount() {
        return listaAbonamente.size();
    }

    @Override
    public Abonament getItem(int i) {
        return listaAbonamente.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View viewItem = inflater.inflate(R.layout.row_listview, viewGroup, false);

        TextView textViewNume = viewItem.findViewById(R.id.nume);
        TextView textViewDescriere = viewItem.findViewById(R.id.descriere);
        TextView textViewPret = viewItem.findViewById(R.id.pret);

        Abonament temp = listaAbonamente.get(i);

        textViewNume.setText(temp.getNume());
        textViewDescriere.setText(temp.getDescriere());
        textViewPret.setText(String.valueOf(temp.getPret()));

        return viewItem;

    }
}
