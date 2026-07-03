package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.getAttr(context, C0525R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
        this.mShouldUseGeneratedIds = true;
    }

    @Override // androidx.preference.PreferenceGroup
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListener;
        if (getIntent() != null || getFragment() != null || getPreferenceCount() == 0 || (onNavigateToScreenListener = getPreferenceManager().getOnNavigateToScreenListener()) == null) {
            return;
        }
        onNavigateToScreenListener.onNavigateToScreen(this);
    }

    public void setShouldUseGeneratedIds(boolean z2) {
        if (isAttached()) {
            throw new IllegalStateException("Cannot change the usage of generated IDs while attached to the preference hierarchy");
        }
        this.mShouldUseGeneratedIds = z2;
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }
}
