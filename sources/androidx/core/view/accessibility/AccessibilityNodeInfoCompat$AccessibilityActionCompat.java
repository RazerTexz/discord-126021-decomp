package androidx.core.view.accessibility;

import android.R$id;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat$AccessibilityActionCompat {
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_HIDE_TOOLTIP;

    @NonNull
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_IME_ENTER;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_MOVE_WINDOW;

    @NonNull
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_DOWN;

    @NonNull
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_LEFT;

    @NonNull
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_RIGHT;

    @NonNull
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_UP;

    @NonNull
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_DOWN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_LEFT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_UP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_PROGRESS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
    private static final String TAG = "A11yActionCompat";
    public final Object mAction;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public final AccessibilityViewCommand mCommand;
    private final int mId;
    private final Class<? extends AccessibilityViewCommand$CommandArguments> mViewCommandArgumentClass;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SELECT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(64, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(128, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand$CommandArguments>) AccessibilityViewCommand$MoveAtGranularityArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand$CommandArguments>) AccessibilityViewCommand$MoveAtGranularityArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand$CommandArguments>) AccessibilityViewCommand$MoveHtmlArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand$CommandArguments>) AccessibilityViewCommand$MoveHtmlArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4096, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8192, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COPY = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16384, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PASTE = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32768, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CUT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(65536, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand$CommandArguments>) AccessibilityViewCommand$SetSelectionArguments.class);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_EXPAND = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(262144, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(524288, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DISMISS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1048576, null);
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand$CommandArguments>) AccessibilityViewCommand$SetTextArguments.class);

    static {
        int i = Build$VERSION.SDK_INT;
        ACTION_SHOW_ON_SCREEN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R$id.accessibilityActionShowOnScreen, null, null, null);
        ACTION_SCROLL_TO_POSITION = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R$id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand$ScrollToPositionArguments.class);
        ACTION_SCROLL_UP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_UP : null, R$id.accessibilityActionScrollUp, null, null, null);
        ACTION_SCROLL_LEFT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_LEFT : null, R$id.accessibilityActionScrollLeft, null, null, null);
        ACTION_SCROLL_DOWN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_DOWN : null, R$id.accessibilityActionScrollDown, null, null, null);
        ACTION_SCROLL_RIGHT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_RIGHT : null, R$id.accessibilityActionScrollRight, null, null, null);
        ACTION_PAGE_UP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_UP : null, R$id.accessibilityActionPageUp, null, null, null);
        ACTION_PAGE_DOWN = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_DOWN : null, R$id.accessibilityActionPageDown, null, null, null);
        ACTION_PAGE_LEFT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_LEFT : null, R$id.accessibilityActionPageLeft, null, null, null);
        ACTION_PAGE_RIGHT = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_RIGHT : null, R$id.accessibilityActionPageRight, null, null, null);
        ACTION_CONTEXT_CLICK = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 23 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_CONTEXT_CLICK : null, R$id.accessibilityActionContextClick, null, null, null);
        ACTION_SET_PROGRESS = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 24 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SET_PROGRESS : null, R$id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand$SetProgressArguments.class);
        ACTION_MOVE_WINDOW = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 26 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_MOVE_WINDOW : null, R$id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand$MoveWindowArguments.class);
        ACTION_SHOW_TOOLTIP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 28 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R$id.accessibilityActionShowTooltip, null, null, null);
        ACTION_HIDE_TOOLTIP = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 28 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R$id.accessibilityActionHideTooltip, null, null, null);
        ACTION_PRESS_AND_HOLD = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 30 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R$id.accessibilityActionPressAndHold, null, null, null);
        ACTION_IME_ENTER = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i >= 30 ? AccessibilityNodeInfo$AccessibilityAction.ACTION_IME_ENTER : null, R$id.accessibilityActionImeEnter, null, null, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int i, CharSequence charSequence) {
        this(null, i, charSequence, null, null);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityNodeInfoCompat$AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        return new AccessibilityNodeInfoCompat$AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat$AccessibilityActionCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfoCompat$AccessibilityActionCompat) obj;
        Object obj2 = this.mAction;
        if (obj2 == null) {
            return accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction == null;
        }
        return obj2.equals(accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction);
    }

    public int getId() {
        return ((AccessibilityNodeInfo$AccessibilityAction) this.mAction).getId();
    }

    public CharSequence getLabel() {
        return ((AccessibilityNodeInfo$AccessibilityAction) this.mAction).getLabel();
    }

    public int hashCode() {
        Object obj = this.mAction;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean perform(View view, Bundle bundle) {
        if (this.mCommand == null) {
            return false;
        }
        AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments = null;
        Class<? extends AccessibilityViewCommand$CommandArguments> cls = this.mViewCommandArgumentClass;
        if (cls != null) {
            try {
                AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArgumentsNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                try {
                    accessibilityViewCommand$CommandArgumentsNewInstance.setBundle(bundle);
                    accessibilityViewCommand$CommandArguments = accessibilityViewCommand$CommandArgumentsNewInstance;
                } catch (Exception e) {
                    e = e;
                    accessibilityViewCommand$CommandArguments = accessibilityViewCommand$CommandArgumentsNewInstance;
                    Class<? extends AccessibilityViewCommand$CommandArguments> cls2 = this.mViewCommandArgumentClass;
                    Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return this.mCommand.perform(view, accessibilityViewCommand$CommandArguments);
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        this(null, i, charSequence, accessibilityViewCommand, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object obj) {
        this(obj, 0, null, null, null);
    }

    private AccessibilityNodeInfoCompat$AccessibilityActionCompat(int i, CharSequence charSequence, Class<? extends AccessibilityViewCommand$CommandArguments> cls) {
        this(null, i, charSequence, null, cls);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand$CommandArguments> cls) {
        this.mId = i;
        this.mCommand = accessibilityViewCommand;
        if (obj == null) {
            this.mAction = new AccessibilityNodeInfo$AccessibilityAction(i, charSequence);
        } else {
            this.mAction = obj;
        }
        this.mViewCommandArgumentClass = cls;
    }
}
