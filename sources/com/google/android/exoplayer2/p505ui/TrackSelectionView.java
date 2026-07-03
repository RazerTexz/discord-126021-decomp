package com.google.android.exoplayer2.p505ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p255c3.C2642h;
import p007b.p225i.p226a.p242c.p256d3.C2668l;
import p007b.p225i.p226a.p242c.p256d3.InterfaceC2672p;

/* JADX INFO: loaded from: classes3.dex */
public class TrackSelectionView extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public final int f20200j;

    /* JADX INFO: renamed from: k */
    public final LayoutInflater f20201k;

    /* JADX INFO: renamed from: l */
    public final CheckedTextView f20202l;

    /* JADX INFO: renamed from: m */
    public final CheckedTextView f20203m;

    /* JADX INFO: renamed from: n */
    public final ViewOnClickListenerC10762b f20204n;

    /* JADX INFO: renamed from: o */
    public final SparseArray<C2642h.f> f20205o;

    /* JADX INFO: renamed from: p */
    public boolean f20206p;

    /* JADX INFO: renamed from: q */
    public boolean f20207q;

    /* JADX INFO: renamed from: r */
    public InterfaceC2672p f20208r;

    /* JADX INFO: renamed from: s */
    public C2558o0 f20209s;

    /* JADX INFO: renamed from: t */
    public boolean f20210t;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.TrackSelectionView$b */
    public class ViewOnClickListenerC10762b implements View.OnClickListener {
        public ViewOnClickListenerC10762b(C10761a c10761a) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView trackSelectionView = TrackSelectionView.this;
            if (view == trackSelectionView.f20202l) {
                trackSelectionView.f20210t = true;
                trackSelectionView.f20205o.clear();
            } else {
                if (view != trackSelectionView.f20203m) {
                    trackSelectionView.f20210t = false;
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag);
                    trackSelectionView.f20205o.get(((C10763c) tag).f20212a);
                    Objects.requireNonNull(null);
                    throw null;
                }
                trackSelectionView.f20210t = false;
                trackSelectionView.f20205o.clear();
            }
            trackSelectionView.m8932a();
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.TrackSelectionView$c */
    public static final class C10763c {

        /* JADX INFO: renamed from: a */
        public final int f20212a;
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        this.f20205o = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f20200j = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f20201k = layoutInflaterFrom;
        ViewOnClickListenerC10762b viewOnClickListenerC10762b = new ViewOnClickListenerC10762b(null);
        this.f20204n = viewOnClickListenerC10762b;
        this.f20208r = new C2668l(getResources());
        this.f20209s = C2558o0.f5674j;
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f20202l = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(C10759R.f.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(viewOnClickListenerC10762b);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(C10759R.e.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f20203m = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(C10759R.f.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(viewOnClickListenerC10762b);
        addView(checkedTextView2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8932a() {
        this.f20202l.setChecked(this.f20210t);
        this.f20203m.setChecked(!this.f20210t && this.f20205o.size() == 0);
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public final void m8933b() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount < 3) {
                this.f20202l.setEnabled(false);
                this.f20203m.setEnabled(false);
                return;
            }
            removeViewAt(childCount);
        }
    }

    public boolean getIsDisabled() {
        return this.f20210t;
    }

    public List<C2642h.f> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f20205o.size());
        for (int i = 0; i < this.f20205o.size(); i++) {
            arrayList.add(this.f20205o.valueAt(i));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.f20206p != z2) {
            this.f20206p = z2;
            m8933b();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.f20207q != z2) {
            this.f20207q = z2;
            if (!z2 && this.f20205o.size() > 1) {
                for (int size = this.f20205o.size() - 1; size > 0; size--) {
                    this.f20205o.remove(size);
                }
            }
            m8933b();
        }
    }

    public void setShowDisableOption(boolean z2) {
        this.f20202l.setVisibility(z2 ? 0 : 8);
    }

    public void setTrackNameProvider(InterfaceC2672p interfaceC2672p) {
        Objects.requireNonNull(interfaceC2672p);
        this.f20208r = interfaceC2672p;
        m8933b();
    }
}
