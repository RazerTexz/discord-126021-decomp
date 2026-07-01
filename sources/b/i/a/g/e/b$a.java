package b.i.a.g.e;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a extends Property<ExtendedFloatingActionButton, Float> {
    public final /* synthetic */ b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$a(b bVar, Class cls, String str) {
        super(cls, str);
        this.a = bVar;
    }

    @Override // android.util.Property
    public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
        ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
        return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton2.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), this.a.f1611b.originalTextCsl.getDefaultColor()))));
    }

    @Override // android.util.Property
    public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
        ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
        Float f2 = f;
        int colorForState = extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), this.a.f1611b.originalTextCsl.getDefaultColor());
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
        if (f2.floatValue() == 1.0f) {
            extendedFloatingActionButton2.silentlyUpdateTextColor(extendedFloatingActionButton2.originalTextCsl);
        } else {
            extendedFloatingActionButton2.silentlyUpdateTextColor(colorStateListValueOf);
        }
    }
}
