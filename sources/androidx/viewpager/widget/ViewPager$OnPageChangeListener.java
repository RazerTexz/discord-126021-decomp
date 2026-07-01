package androidx.viewpager.widget;

import androidx.annotation.Px;

/* JADX INFO: loaded from: classes.dex */
public interface ViewPager$OnPageChangeListener {
    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, @Px int i2);

    void onPageSelected(int i);
}
