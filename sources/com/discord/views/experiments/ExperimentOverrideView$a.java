package com.discord.views.experiments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import b.a.i.u3;
import com.discord.R$layout;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ExperimentOverrideView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverrideView$a extends ArrayAdapter<ExperimentOverrideView$b> {
    public final List<ExperimentOverrideView$b> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentOverrideView$a(Context context, List<ExperimentOverrideView$b> list) {
        super(context, R$layout.view_simple_spinner_dropdown_item, list);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(list, "items");
        this.j = list;
    }

    public final View a(int i, View view) {
        View view2 = view;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_simple_spinner_dropdown_item, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            m.checkNotNullExpressionValue(new u3(textView), "ViewSimpleSpinnerDropdow…om(context), null, false)");
            m.checkNotNullExpressionValue(textView, "ViewSimpleSpinnerDropdow…ntext), null, false).root");
            view2 = textView;
        }
        ((TextView) view2).setText(this.j.get(i).f2842b);
        return view2;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.j.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "parent");
        return a(i, view);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public Object getItem(int i) {
        return this.j.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        Integer num = this.j.get(i).a;
        if (num != null) {
            return num.intValue();
        }
        return -1L;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "parent");
        return a(i, view);
    }
}
