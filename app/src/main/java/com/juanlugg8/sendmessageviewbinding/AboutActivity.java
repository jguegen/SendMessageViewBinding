package com.juanlugg8.sendmessageviewbinding;

import android.content.Context;

import androidx.annotation.NonNull;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.*;

class AboutActivity extends MaterialAboutActivity {
    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        MaterialAboutCard.Builder cardBuilder = new MaterialAboutCard.Builder();

        cardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text("Personal information")
                .build());

        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("Autor")
                .subText("Juan Luis Guerra Gennich")
                //.icon(R.drawable.ic_about_info)
                .build());

        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("Fork on GitHUB")
                .subText("1.0.0")
                //.icon(R.drawable.ic_about_info)
                .build());

        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("Version")
                .subText("1.0.0")
                //.icon(R.drawable.ic_about_info)
                .build());

        return new MaterialAboutList.Builder()
                .addCard(cardBuilder.build()).build();
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(com.danielstone.materialaboutlibrary.R.string.mal_title_about);
    }
}
