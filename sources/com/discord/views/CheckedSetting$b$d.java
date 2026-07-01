package com.discord.views;

import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.s3;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.m;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$b$d extends CheckedSetting$b$c {
    public final ConstraintLayout e;
    public final SwitchMaterial f;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckedSetting$b$d(s3 s3Var) {
        m.checkNotNullParameter(s3Var, "binding");
        ConstraintLayout constraintLayout = s3Var.c;
        m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
        super(constraintLayout, null, 2);
        ConstraintLayout constraintLayout2 = s3Var.c;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
        this.e = constraintLayout2;
        SwitchMaterial switchMaterial = s3Var.f198b;
        m.checkNotNullExpressionValue(switchMaterial, "binding.settingButton");
        this.f = switchMaterial;
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
