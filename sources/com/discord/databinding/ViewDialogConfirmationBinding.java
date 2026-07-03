package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewDialogConfirmationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15420a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15421b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15422c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15423d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15424e;

    public ViewDialogConfirmationBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15420a = linearLayout;
        this.f15421b = materialButton;
        this.f15422c = materialButton2;
        this.f15423d = textView;
        this.f15424e = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewDialogConfirmationBinding m8393a(@NonNull View view) {
        int i = C5419R.id.view_dialog_confirmation_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.view_dialog_confirmation_cancel);
        if (materialButton != null) {
            i = C5419R.id.view_dialog_confirmation_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.view_dialog_confirmation_confirm);
            if (materialButton2 != null) {
                i = C5419R.id.view_dialog_confirmation_header;
                TextView textView = (TextView) view.findViewById(C5419R.id.view_dialog_confirmation_header);
                if (textView != null) {
                    i = C5419R.id.view_dialog_confirmation_text;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.view_dialog_confirmation_text);
                    if (textView2 != null) {
                        return new ViewDialogConfirmationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static ViewDialogConfirmationBinding m8394b(@NonNull LayoutInflater layoutInflater) {
        return m8393a(layoutInflater.inflate(C5419R.layout.view_dialog_confirmation, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15420a;
    }
}
