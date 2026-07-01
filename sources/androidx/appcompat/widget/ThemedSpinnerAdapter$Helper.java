package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class ThemedSpinnerAdapter$Helper {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;

    public ThemedSpinnerAdapter$Helper(@NonNull Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    public LayoutInflater getDropDownViewInflater() {
        LayoutInflater layoutInflater = this.mDropDownInflater;
        return layoutInflater != null ? layoutInflater : this.mInflater;
    }

    @Nullable
    public Resources$Theme getDropDownViewTheme() {
        LayoutInflater layoutInflater = this.mDropDownInflater;
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.getContext().getTheme();
    }

    public void setDropDownViewTheme(@Nullable Resources$Theme resources$Theme) {
        if (resources$Theme == null) {
            this.mDropDownInflater = null;
        } else if (resources$Theme == this.mContext.getTheme()) {
            this.mDropDownInflater = this.mInflater;
        } else {
            this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, resources$Theme));
        }
    }
}
