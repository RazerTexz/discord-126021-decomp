package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import b.f.g.c.c;

/* JADX INFO: loaded from: classes.dex */
public class AbstractDraweeControllerBuilder$a extends c<Object> {
    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        if (animatable != null) {
            animatable.start();
        }
    }
}
