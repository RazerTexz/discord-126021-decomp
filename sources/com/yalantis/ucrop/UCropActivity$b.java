package com.yalantis.ucrop;

import android.graphics.Bitmap$CompressFormat;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity$b implements View$OnClickListener {
    public final /* synthetic */ UCropActivity j;

    public UCropActivity$b(UCropActivity uCropActivity) {
        this.j = uCropActivity;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        if (view.isSelected()) {
            return;
        }
        UCropActivity uCropActivity = this.j;
        int id2 = view.getId();
        Bitmap$CompressFormat bitmap$CompressFormat = UCropActivity.j;
        uCropActivity.c(id2);
    }
}
