package com.yalantis.ucrop;

import android.widget.TextView;
import b.q.a.l.c$a;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity$a implements c$a {
    public final /* synthetic */ UCropActivity a;

    public UCropActivity$a(UCropActivity uCropActivity) {
        this.a = uCropActivity;
    }

    public void a(float f) {
        TextView textView = this.a.F;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
        }
    }

    public void b(float f) {
        TextView textView = this.a.G;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }
}
