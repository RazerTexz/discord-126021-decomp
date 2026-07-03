package androidx.browser.trusted;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface TrustedWebActivityDisplayMode {
    public static final String KEY_ID = "androidx.browser.trusted.displaymode.KEY_ID";

    public static class DefaultMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f89ID = 0;

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        @NonNull
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 0);
            return bundle;
        }
    }

    public static class ImmersiveMode implements TrustedWebActivityDisplayMode {

        /* JADX INFO: renamed from: ID */
        private static final int f90ID = 1;
        public static final String KEY_CUTOUT_MODE = "androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE";
        public static final String KEY_STICKY = "androidx.browser.trusted.displaymode.KEY_STICKY";
        private final boolean mIsSticky;
        private final int mLayoutInDisplayCutoutMode;

        public ImmersiveMode(boolean z2, int i) {
            this.mIsSticky = z2;
            this.mLayoutInDisplayCutoutMode = i;
        }

        @NonNull
        public static TrustedWebActivityDisplayMode fromBundle(@NonNull Bundle bundle) {
            return new ImmersiveMode(bundle.getBoolean(KEY_STICKY), bundle.getInt(KEY_CUTOUT_MODE));
        }

        public boolean isSticky() {
            return this.mIsSticky;
        }

        public int layoutInDisplayCutoutMode() {
            return this.mLayoutInDisplayCutoutMode;
        }

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        @NonNull
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 1);
            bundle.putBoolean(KEY_STICKY, this.mIsSticky);
            bundle.putInt(KEY_CUTOUT_MODE, this.mLayoutInDisplayCutoutMode);
            return bundle;
        }
    }

    @NonNull
    Bundle toBundle();
}
