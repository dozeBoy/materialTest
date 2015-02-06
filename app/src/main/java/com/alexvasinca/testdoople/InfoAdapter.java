package com.alexvasinca.testdoople;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex Vasinca on 02/06/2015.
 * <p/>
 * This is another adapter created with the purpose of displaying cards
 * in the MainActivity together with the new CardView support library
 * in Android L
 * <p/>
 * Could have made the other adapter a little more generic but maybe in the future,
 * after the learning phase.
 */
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private List<CardInfo> cardInfoList;

    public InfoAdapter(List<CardInfo> cardInfoList) {
        this.cardInfoList = cardInfoList;
    }


    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new InfoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        CardInfo cardInfo = cardInfoList.get(position);
        holder.vName.setText(cardInfo.name);
        holder.vSurname.setText(cardInfo.surName);
        holder.vEmail.setText(cardInfo.email);
        holder.vAdress.setText(cardInfo.adress);
        holder.vTitle.setText(cardInfo.name + " " + cardInfo.surName);
    }


    @Override
    public int getItemCount() {
        return cardInfoList.size();
    }

    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vAdress;
        protected TextView vTitle;

        public InfoViewHolder(View itemView) {
            super(itemView);
            vName = (TextView) itemView.findViewById(R.id.textName);
            vSurname = (TextView) itemView.findViewById(R.id.textSurname);
            vEmail = (TextView) itemView.findViewById(R.id.textEmail);
            vTitle = (TextView) itemView.findViewById(R.id.title);
            vAdress = (TextView) itemView.findViewById(R.id.textAdress);
        }


    }
}
