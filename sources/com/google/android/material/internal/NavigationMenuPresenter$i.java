package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R$layout;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationMenuPresenter$i extends NavigationMenuPresenter$l {
    public NavigationMenuPresenter$i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View$OnClickListener view$OnClickListener) {
        super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
        this.itemView.setOnClickListener(view$OnClickListener);
    }
}
