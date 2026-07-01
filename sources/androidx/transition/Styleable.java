package androidx.transition;

import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"InlinedApi"})
public class Styleable {

    @StyleableRes
    public static final int[] TRANSITION_TARGET = {android.R$attr.targetClass, android.R$attr.targetId, android.R$attr.excludeId, android.R$attr.excludeClass, android.R$attr.targetName, android.R$attr.excludeName};

    @StyleableRes
    public static final int[] TRANSITION_MANAGER = {android.R$attr.fromScene, android.R$attr.toScene, android.R$attr.transition};

    @StyleableRes
    public static final int[] TRANSITION = {android.R$attr.interpolator, android.R$attr.duration, android.R$attr.startDelay, android.R$attr.matchOrder};

    @StyleableRes
    public static final int[] CHANGE_BOUNDS = {android.R$attr.resizeClip};

    @StyleableRes
    public static final int[] VISIBILITY_TRANSITION = {android.R$attr.transitionVisibilityMode};

    @StyleableRes
    public static final int[] FADE = {android.R$attr.fadingMode};

    @StyleableRes
    public static final int[] CHANGE_TRANSFORM = {android.R$attr.reparent, android.R$attr.reparentWithOverlay};

    @StyleableRes
    public static final int[] SLIDE = {android.R$attr.slideEdge};

    @StyleableRes
    public static final int[] TRANSITION_SET = {android.R$attr.transitionOrdering};

    @StyleableRes
    public static final int[] ARC_MOTION = {android.R$attr.minimumHorizontalAngle, android.R$attr.minimumVerticalAngle, android.R$attr.maximumAngle};

    @StyleableRes
    public static final int[] PATTERN_PATH_MOTION = {android.R$attr.patternPathData};

    private Styleable() {
    }
}
