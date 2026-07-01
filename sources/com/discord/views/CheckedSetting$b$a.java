package com.discord.views;

import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.p3;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$b$a extends CheckedSetting$b$c {
    public final ConstraintLayout e;
    public final MaterialCheckBox f;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckedSetting$b$a(p3 p3Var) {
        m.checkNotNullParameter(p3Var, "binding");
        ConstraintLayout constraintLayout = p3Var.c;
        m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
        super(constraintLayout, null, 2);
        ConstraintLayout constraintLayout2 = p3Var.c;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
        this.e = constraintLayout2;
        MaterialCheckBox materialCheckBox = p3Var.f180b;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.settingButton");
        this.f = materialCheckBox;
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
