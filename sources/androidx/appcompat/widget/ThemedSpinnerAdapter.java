package androidx.appcompat.widget;

import android.content.res.Resources$Theme;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {
    @Nullable
    Resources$Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources$Theme resources$Theme);
}
