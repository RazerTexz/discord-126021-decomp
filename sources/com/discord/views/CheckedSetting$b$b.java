package com.discord.views;

import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.q3;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$b$b extends CheckedSetting$b$c {
    public final ConstraintLayout e;
    public final MaterialRadioButton f;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckedSetting$b$b(q3 q3Var) {
        m.checkNotNullParameter(q3Var, "binding");
        ConstraintLayout constraintLayout = q3Var.c;
        m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
        super(constraintLayout, null, 2);
        ConstraintLayout constraintLayout2 = q3Var.c;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
        this.e = constraintLayout2;
        MaterialRadioButton materialRadioButton = q3Var.f186b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.settingButton");
        this.f = materialRadioButton;
    }

    @Override // com.discord.views.CheckedSetting$b
    public View b() {
        return this.e;
    }

    @Override // com.discord.views.CheckedSetting$b
    public CompoundButton c() {
        return this.f;
    }
}
