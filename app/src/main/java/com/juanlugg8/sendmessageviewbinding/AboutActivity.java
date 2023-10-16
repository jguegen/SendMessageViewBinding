package com.juanlugg8.sendmessageviewbinding;

import android.content.Context;

import androidx.annotation.NonNull;

import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

class AboutActivity extends com.danielstone.materialaboutlibrary.MaterialAboutActivity {
    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        return new MaterialAboutList.Builder()
                .build(); // This creates an empty screen, add cards with .addCard()
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(com.danielstone.materialaboutlibrary.R.string.mal_title_about);
    }
}
