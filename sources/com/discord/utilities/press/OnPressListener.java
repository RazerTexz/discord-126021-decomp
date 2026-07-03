package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: OnPressListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnPressListener implements View.OnTouchListener {
    private final OnPress onPress;
    private boolean pressed;

    /* JADX INFO: compiled from: OnPressListener.kt */
    public interface OnPress {
        void onPress(boolean pressed);
    }

    public OnPressListener(OnPress onPress) {
        C12238m.checkNotNullParameter(onPress, "onPress");
        this.onPress = onPress;
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        boolean zBooleanValue;
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(event, "event");
        Boolean boolIsPressed = isPressed(event);
        if (boolIsPressed == null || this.pressed == (zBooleanValue = boolIsPressed.booleanValue())) {
            return false;
        }
        this.pressed = zBooleanValue;
        this.onPress.onPress(zBooleanValue);
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnPressListener(final Function1<? super Boolean, Unit> function1) {
        this(new OnPress() { // from class: com.discord.utilities.press.OnPressListener.1
            @Override // com.discord.utilities.press.OnPressListener.OnPress
            public void onPress(boolean pressed) {
                function1.invoke(Boolean.valueOf(pressed));
            }
        });
        C12238m.checkNotNullParameter(function1, "onPress");
    }
}
