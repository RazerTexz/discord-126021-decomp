package com.discord.views.steps;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsView$d extends FragmentStateAdapter {
    public List<? extends StepsView$b> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsView$d(Fragment fragment, List<? extends StepsView$b> list) {
        super(fragment);
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(list, "steps");
        this.a = list;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) throws IllegalAccessException, InstantiationException {
        StepsView$b stepsView$b = this.a.get(i);
        if (!(stepsView$b instanceof StepsView$b$a)) {
            if (!(stepsView$b instanceof StepsView$b$b)) {
                return new Fragment();
            }
            Objects.requireNonNull((StepsView$b$b) stepsView$b);
            return new StepsView$c(0);
        }
        StepsView$b$a stepsView$b$a = (StepsView$b$a) stepsView$b;
        Fragment fragmentNewInstance = stepsView$b$a.j.newInstance();
        Fragment fragment = fragmentNewInstance;
        fragment.setArguments(stepsView$b$a.n);
        m.checkNotNullExpressionValue(fragmentNewInstance, "currentStep.fragment.new…tep.arguments\n          }");
        return fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
