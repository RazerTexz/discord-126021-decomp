package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OnPressListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnPressListener implements View$OnTouchListener {
    private final OnPressListener$OnPress onPress;
    private boolean pressed;

    public OnPressListener(OnPressListener$OnPress onPressListener$OnPress) {
        m.checkNotNullParameter(onPressListener$OnPress, "onPress");
        this.onPress = onPressListener$OnPress;
    }

    private final Boolean isPressed(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                if (action != 5) {
                    if (action != 6) {
                        return null;
                    }
                }
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        boolean zBooleanValue;
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(event, "event");
        Boolean boolIsPressed = isPressed(event);
        if (boolIsPressed == null || this.pressed == (zBooleanValue = boolIsPressed.booleanValue())) {
            return false;
        }
        this.pressed = zBooleanValue;
        this.onPress.onPress(zBooleanValue);
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnPressListener(Function1<? super Boolean, Unit> function1) {
        this(new OnPressListener$1(function1));
        m.checkNotNullParameter(function1, "onPress");
    }
}
