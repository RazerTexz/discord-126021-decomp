package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewDialogConfirmationBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2185b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ViewDialogConfirmationBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2185b = materialButton;
        this.c = materialButton2;
        this.d = textView;
        this.e = textView2;
    }

    @NonNull
    public static ViewDialogConfirmationBinding a(@NonNull View view) {
        int i = R.id.view_dialog_confirmation_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.view_dialog_confirmation_cancel);
        if (materialButton != null) {
            i = R.id.view_dialog_confirmation_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.view_dialog_confirmation_confirm);
            if (materialButton2 != null) {
                i = R.id.view_dialog_confirmation_header;
                TextView textView = (TextView) view.findViewById(R.id.view_dialog_confirmation_header);
                if (textView != null) {
                    i = R.id.view_dialog_confirmation_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.view_dialog_confirmation_text);
                    if (textView2 != null) {
                        return new ViewDialogConfirmationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewDialogConfirmationBinding b(@NonNull LayoutInflater layoutInflater) {
        return a(layoutInflater.inflate(R.layout.view_dialog_confirmation, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
