package com.discord.chips_view;

import android.R$color;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.style.LeadingMarginSpan$Standard;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.f.a;
import b.a.f.a$a;
import b.a.f.b;
import b.a.f.d;
import b.a.f.d$a;
import b.a.f.e;
import b.a.f.e$a;
import b.a.f.f;
import b.a.f.g;
import com.discord.chips_view.ChipsView$a;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView<K, V extends ChipsView$a> extends ScrollView implements d$a {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final d mEditText;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public e mRootChipsLayout;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final LinkedHashMap<K, a<K, V>> mChipList;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public Object mCurrentEditTextSpan;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipAddedListener;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipDeletedListener;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    public Function1<? super CharSequence, Unit> textChangedListener;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int mChipsBgResId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int mMaxHeight;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int mVerticalSpacingPx;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int mChipHeightPx;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int mChipsColor;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int mChipsColorClicked;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public int mChipsBgColor;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int mChipsBgColorClicked;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public int mChipsTextColor;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public int mChipsTextColorClicked;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public int mChipsSearchTextColor;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public float mChipsSearchTextSize;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public int mChipsHintRes;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public int mChipLayout;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public float mDensity;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final RelativeLayout mChipsContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.mChipList = new LinkedHashMap<>();
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        this.mDensity = resources.getDisplayMetrics().density;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mChipsContainer = relativeLayout;
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup$LayoutParams(0, 0));
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        relativeLayout.addView(linearLayout);
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        d dVar = new d(context2, this);
        this.mEditText = dVar;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$c.ChipsView, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…tyleable.ChipsView, 0, 0)");
        try {
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$c.ChipsView_cv_max_height, -1);
            this.mVerticalSpacingPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$c.ChipsView_cv_vertical_spacing, (int) (1 * this.mDensity));
            this.mChipHeightPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$c.ChipsView_cv_height, (int) (24 * this.mDensity));
            this.mChipsColor = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_color, ContextCompat.getColor(context, R$color.darker_gray));
            this.mChipsColorClicked = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_color_clicked, ContextCompat.getColor(context, R$color.white));
            this.mChipsBgColor = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_bg_color, ContextCompat.getColor(context, R$color.white));
            this.mChipsBgResId = typedArrayObtainStyledAttributes.getResourceId(R$c.ChipsView_cv_chip_bg_res, 0);
            this.mChipsBgColorClicked = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_bg_color_clicked, ContextCompat.getColor(context, R$color.holo_blue_dark));
            this.mChipsTextColor = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsTextColorClicked = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_text_color_clicked, -1);
            this.mChipsHintRes = typedArrayObtainStyledAttributes.getResourceId(R$c.ChipsView_cv_hint, 0);
            typedArrayObtainStyledAttributes.getResourceId(R$c.ChipsView_cv_icon_placeholder, 0);
            this.mChipsSearchTextColor = typedArrayObtainStyledAttributes.getColor(R$c.ChipsView_cv_search_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsSearchTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$c.ChipsView_cv_search_text_size, 49);
            this.mChipLayout = typedArrayObtainStyledAttributes.getResourceId(R$c.ChipsView_cv_chip_layout, R$b.view_chip_default);
            typedArrayObtainStyledAttributes.recycle();
            int i = this.mChipHeightPx + this.mVerticalSpacingPx;
            RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-1, i);
            float f = 4;
            relativeLayout$LayoutParams.leftMargin = (int) (this.mDensity * f);
            relativeLayout$LayoutParams.addRule(12, -1);
            dVar.setLayoutParams(relativeLayout$LayoutParams);
            dVar.setPadding(0, 0, 0, this.mVerticalSpacingPx);
            dVar.setBackgroundColor(Color.argb(0, 0, 0, 0));
            dVar.setImeOptions(268435456);
            dVar.setInputType(1);
            dVar.setTextColor(this.mChipsSearchTextColor);
            dVar.setTextSize(0, this.mChipsSearchTextSize);
            relativeLayout.addView(dVar);
            Context context3 = getContext();
            m.checkNotNullExpressionValue(context3, "context");
            e eVar = new e(context3, i);
            eVar.setOrientation(1);
            eVar.setLayoutParams(new ViewGroup$LayoutParams(-1, -2));
            eVar.setPadding(0, (int) (f * this.mDensity), 0, 0);
            this.mRootChipsLayout = eVar;
            relativeLayout.addView(eVar);
            relativeLayout.setOnClickListener(new g(this));
            dVar.addTextChangedListener(new ChipsView$b(this));
            dVar.setOnFocusChangeListener(new f(this));
            c(false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // b.a.f.d$a
    public InputConnection a(InputConnection target) {
        return new ChipsView$c(this, target);
    }

    public final void b(String displayName, String imageContentDescription, K key, V data) {
        if (this.mChipList.containsKey(key)) {
            return;
        }
        this.mEditText.setText("");
        a<K, V> aVar = new a<>(displayName, imageContentDescription, key, data, new a$a(this.mChipsBgColorClicked, this.mDensity, this.mChipsBgResId, this.mChipsBgColor, this.mChipsTextColor, this.mChipsTextColorClicked, this.mChipsColorClicked, this.mChipsColor, this.mChipHeightPx, this.mChipLayout), this);
        Editable text = this.mEditText.getText();
        if (text != null) {
            Object obj = this.mCurrentEditTextSpan;
            if (obj != null) {
                text.removeSpan(obj);
            }
            text.setSpan(this.mCurrentEditTextSpan, 0, 0, 17);
        }
        this.mEditText.setText(text);
        this.mChipList.put(key, aVar);
        Function1<? super V, Unit> function1 = this.chipAddedListener;
        if (function1 != null) {
            function1.invoke((Object) aVar.o);
        }
        c(true);
        post(new ChipsView$d(this));
    }

    public final void c(boolean moveCursor) {
        TextView textView;
        RelativeLayout relativeLayout;
        Drawable background;
        TextView textView2;
        RelativeLayout relativeLayout2;
        Drawable background2;
        TextView textView3;
        TextView textView4;
        ImageView imageView;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        e eVar = this.mRootChipsLayout;
        e$a e_a = null;
        if (eVar != null) {
            Collection<a<K, V>> collectionValues = this.mChipList.values();
            m.checkNotNullExpressionValue(collectionValues, "mChipList.values");
            m.checkNotNullParameter(collectionValues, "chips");
            Iterator<LinearLayout> it = eVar.j.iterator();
            while (it.hasNext()) {
                it.next().removeAllViews();
            }
            eVar.j.clear();
            eVar.removeAllViews();
            int width = eVar.getWidth();
            if (width != 0) {
                LinearLayout linearLayoutA = eVar.a();
                int i = 0;
                int i2 = 0;
                for (a<K, V> aVar : collectionValues) {
                    if (aVar.j == null) {
                        View viewInflate = LayoutInflater.from(aVar.q.getContext()).inflate(R$b.view_chip_default, (ViewGroup) null, false);
                        int i3 = R$a.chip_image;
                        ImageView imageView2 = (ImageView) viewInflate.findViewById(i3);
                        if (imageView2 != null) {
                            i3 = R$a.chip_text;
                            TextView textView5 = (TextView) viewInflate.findViewById(i3);
                            if (textView5 != null) {
                                aVar.j = new b.a.f.h.a((RelativeLayout) viewInflate, imageView2, textView5);
                                LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, aVar.p.f);
                                b.a.f.h.a aVar2 = aVar.j;
                                if (aVar2 != null && (relativeLayout4 = aVar2.a) != null) {
                                    relativeLayout4.setLayoutParams(linearLayout$LayoutParams);
                                }
                                b.a.f.h.a aVar3 = aVar.j;
                                if (aVar3 != null && (relativeLayout3 = aVar3.a) != null) {
                                    relativeLayout3.setBackgroundResource(aVar.p.f66b);
                                    relativeLayout3.post(new b(relativeLayout3, aVar));
                                    relativeLayout3.setOnClickListener(aVar);
                                }
                                b.a.f.h.a aVar4 = aVar.j;
                                if (aVar4 != null && (imageView = aVar4.f67b) != null) {
                                    imageView.setOnClickListener(aVar);
                                    m.checkNotNullExpressionValue(imageView, "it");
                                    imageView.setContentDescription(aVar.m);
                                }
                                b.a.f.h.a aVar5 = aVar.j;
                                if (aVar5 != null && (textView4 = aVar5.c) != null) {
                                    textView4.setTextColor(aVar.p.d);
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
                    }
                    b.a.f.h.a aVar6 = aVar.j;
                    if (aVar6 != null && (textView3 = aVar6.c) != null) {
                        textView3.setText(aVar.l);
                    }
                    if (aVar.k) {
                        b.a.f.h.a aVar7 = aVar.j;
                        if (aVar7 != null && (relativeLayout2 = aVar7.a) != null && (background2 = relativeLayout2.getBackground()) != null) {
                            background2.setColorFilter(aVar.p.a, PorterDuff$Mode.SRC_ATOP);
                        }
                        b.a.f.h.a aVar8 = aVar.j;
                        if (aVar8 != null && (textView2 = aVar8.c) != null) {
                            textView2.setTextColor(aVar.p.e);
                        }
                    } else {
                        b.a.f.h.a aVar9 = aVar.j;
                        if (aVar9 != null && (relativeLayout = aVar9.a) != null && (background = relativeLayout.getBackground()) != null) {
                            background.setColorFilter(aVar.p.c, PorterDuff$Mode.SRC_ATOP);
                        }
                        b.a.f.h.a aVar10 = aVar.j;
                        if (aVar10 != null && (textView = aVar10.c) != null) {
                            textView.setTextColor(aVar.p.d);
                        }
                    }
                    b.a.f.h.a aVar11 = aVar.j;
                    RelativeLayout relativeLayout5 = aVar11 != null ? aVar11.a : null;
                    m.checkNotNull(relativeLayout5);
                    relativeLayout5.measure(View$MeasureSpec.makeMeasureSpec(0, 0), View$MeasureSpec.makeMeasureSpec(0, 0));
                    if (relativeLayout5.getMeasuredWidth() + i > width) {
                        i2++;
                        linearLayoutA = eVar.a();
                        i = 0;
                    }
                    int measuredWidth = relativeLayout5.getMeasuredWidth();
                    ViewGroup$LayoutParams layoutParams = relativeLayout5.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    i += measuredWidth + ((LinearLayout$LayoutParams) layoutParams).rightMargin;
                    linearLayoutA.addView(relativeLayout5);
                }
                if (width - i < width * 0.15f) {
                    i2++;
                    eVar.a();
                    i = 0;
                }
                e_a = new e$a(i2, i);
            }
        }
        if (this.mChipList.isEmpty()) {
            int i4 = this.mChipsHintRes;
            if (i4 != 0) {
                this.mEditText.setHint(i4);
            }
        } else {
            this.mEditText.setHint("");
        }
        if (e_a == null) {
            post(new ChipsView$e(this, moveCursor));
            return;
        }
        int i5 = e_a.a;
        Editable text = this.mEditText.getText();
        Object obj = this.mCurrentEditTextSpan;
        if (obj != null && text != null) {
            text.removeSpan(obj);
        }
        LeadingMarginSpan$Standard leadingMarginSpan$Standard = new LeadingMarginSpan$Standard(i5, 0);
        this.mCurrentEditTextSpan = leadingMarginSpan$Standard;
        if (text != null) {
            text.setSpan(leadingMarginSpan$Standard, 0, 0, 17);
        }
        this.mEditText.setText(text);
        if (moveCursor) {
            d dVar = this.mEditText;
            dVar.setSelection(dVar.length());
        }
    }

    public final void d(Collection<?> pruneData) {
        m.checkNotNullParameter(pruneData, "pruneData");
        Iterator<Map$Entry<K, a<K, V>>> it = this.mChipList.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (!u.contains(pruneData, it.next().getKey())) {
                it.remove();
                z2 = true;
            }
        }
        if (z2) {
            c(true);
        }
    }

    public final void e(a<K, V> chip) {
        this.mChipList.remove(chip.n);
        Function1<? super V, Unit> function1 = this.chipDeletedListener;
        if (function1 != null) {
            function1.invoke((Object) chip.o);
        }
        c(true);
    }

    public final void f(a<?, ?> rootChip) {
        for (a<K, V> aVar : this.mChipList.values()) {
            if (aVar != rootChip) {
                aVar.k = false;
            }
        }
        c(false);
    }

    public final Function1<V, Unit> getChipAddedListener() {
        return this.chipAddedListener;
    }

    public final Function1<V, Unit> getChipDeletedListener() {
        return this.chipDeletedListener;
    }

    public final String getText() {
        return String.valueOf(this.mEditText.getText());
    }

    public final Function1<CharSequence, Unit> getTextChangedListener() {
        return this.textChangedListener;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View$MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE));
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return true;
    }

    public final void setChipAddedListener(Function1<? super V, Unit> function1) {
        this.chipAddedListener = function1;
    }

    public final void setChipDeletedListener(Function1<? super V, Unit> function1) {
        this.chipDeletedListener = function1;
    }

    public final void setText(String str) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.mEditText.setText(str);
    }

    public final void setTextChangedListener(Function1<? super CharSequence, Unit> function1) {
        this.textChangedListener = function1;
    }
}
