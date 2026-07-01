package com.google.android.exoplayer2.ui;

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
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.DefaultTrackSelector;
import b.i.a.c.d3.DefaultTrackNameProvider;
import b.i.a.c.d3.TrackNameProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class TrackSelectionView extends LinearLayout {
    public final int j;
    public final LayoutInflater k;
    public final CheckedTextView l;
    public final CheckedTextView m;
    public final b n;
    public final SparseArray<DefaultTrackSelector.f> o;
    public boolean p;
    public boolean q;
    public TrackNameProvider r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TrackGroupArray f2977s;
    public boolean t;

    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView trackSelectionView = TrackSelectionView.this;
            if (view == trackSelectionView.l) {
                trackSelectionView.t = true;
                trackSelectionView.o.clear();
            } else {
                if (view != trackSelectionView.m) {
                    trackSelectionView.t = false;
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag);
                    trackSelectionView.o.get(((c) tag).a);
                    Objects.requireNonNull(null);
                    throw null;
                }
                trackSelectionView.t = false;
                trackSelectionView.o.clear();
            }
            trackSelectionView.a();
        }
    }

    public static final class c {
        public final int a;
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        this.o = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.j = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.k = layoutInflaterFrom;
        b bVar = new b(null);
        this.n = bVar;
        this.r = new DefaultTrackNameProvider(getResources());
        this.f2977s = TrackGroupArray.j;
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.l = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.f.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R.e.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.m = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.f.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }

    public final void a() {
        this.l.setChecked(this.t);
        this.m.setChecked(!this.t && this.o.size() == 0);
        throw null;
    }

    public final void b() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount < 3) {
                this.l.setEnabled(false);
                this.m.setEnabled(false);
                return;
            }
            removeViewAt(childCount);
        }
    }

    public boolean getIsDisabled() {
        return this.t;
    }

    public List<DefaultTrackSelector.f> getOverrides() {
        ArrayList arrayList = new ArrayList(this.o.size());
        for (int i = 0; i < this.o.size(); i++) {
            arrayList.add(this.o.valueAt(i));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.p != z2) {
            this.p = z2;
            b();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.q != z2) {
            this.q = z2;
            if (!z2 && this.o.size() > 1) {
                for (int size = this.o.size() - 1; size > 0; size--) {
                    this.o.remove(size);
                }
            }
            b();
        }
    }

    public void setShowDisableOption(boolean z2) {
        this.l.setVisibility(z2 ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        Objects.requireNonNull(trackNameProvider);
        this.r = trackNameProvider;
        b();
    }
}
