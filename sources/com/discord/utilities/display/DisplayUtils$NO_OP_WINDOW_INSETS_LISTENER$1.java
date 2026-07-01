package com.discord.utilities.display;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: DisplayUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisplayUtils$NO_OP_WINDOW_INSETS_LISTENER$1 implements OnApplyWindowInsetsListener {
    public static final DisplayUtils$NO_OP_WINDOW_INSETS_LISTENER$1 INSTANCE = new DisplayUtils$NO_OP_WINDOW_INSETS_LISTENER$1();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }
}
