package com.discord.utilities.simple_pager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.j;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SimplePager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimplePager$Adapter extends FragmentPagerAdapter {
    private final List<SimplePager$Adapter$Item> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplePager$Adapter(FragmentManager fragmentManager, SimplePager$Adapter$Item... simplePager$Adapter$ItemArr) {
        super(fragmentManager, 1);
        m.checkNotNullParameter(fragmentManager, "fm");
        m.checkNotNullParameter(simplePager$Adapter$ItemArr, "items");
        this.items = j.asList(simplePager$Adapter$ItemArr);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.items.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        Function0<Fragment> creator$utils_release;
        Fragment fragmentInvoke;
        SimplePager$Adapter$Item simplePager$Adapter$Item = (SimplePager$Adapter$Item) u.getOrNull(this.items, position);
        if (simplePager$Adapter$Item != null && (creator$utils_release = simplePager$Adapter$Item.getCreator$utils_release()) != null && (fragmentInvoke = creator$utils_release.invoke()) != null) {
            return fragmentInvoke;
        }
        throw new IllegalArgumentException("Invalid position: " + position + '.');
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        String title$utils_release;
        SimplePager$Adapter$Item simplePager$Adapter$Item = (SimplePager$Adapter$Item) u.getOrNull(this.items, position);
        return (simplePager$Adapter$Item == null || (title$utils_release = simplePager$Adapter$Item.getTitle()) == null) ? super.getPageTitle(position) : title$utils_release;
    }
}
