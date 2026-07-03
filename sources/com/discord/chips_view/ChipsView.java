package com.discord.chips_view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.chips_view.ChipsView.InterfaceC5465a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p021f.C0898d;
import p007b.p008a.p021f.C0899e;
import p007b.p008a.p021f.RunnableC0896b;
import p007b.p008a.p021f.ViewOnClickListenerC0895a;
import p007b.p008a.p021f.ViewOnClickListenerC0901g;
import p007b.p008a.p021f.ViewOnFocusChangeListenerC0900f;
import p007b.p008a.p021f.p022h.C0902a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView<K, V extends InterfaceC5465a> extends ScrollView implements C0898d.a {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f14975j = 0;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final C0898d mEditText;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public C0899e mRootChipsLayout;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final LinkedHashMap<K, ViewOnClickListenerC0895a<K, V>> mChipList;

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

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public int mChipsTextColor;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public int mChipsTextColorClicked;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public int mChipsSearchTextColor;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public float mChipsSearchTextSize;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public int mChipsHintRes;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public int mChipLayout;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public float mDensity;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final RelativeLayout mChipsContainer;

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$a */
    /* JADX INFO: compiled from: ChipsView.kt */
    public interface InterfaceC5465a {
        String getDisplayString();
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$b */
    /* JADX INFO: compiled from: ChipsView.kt */
    public final class C5466b implements TextWatcher {
        public C5466b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C12238m.checkNotNullParameter(editable, "s");
            Function1<CharSequence, Unit> textChangedListener = ChipsView.this.getTextChangedListener();
            if (textChangedListener != null) {
                textChangedListener.invoke(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C12238m.checkNotNullParameter(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C12238m.checkNotNullParameter(charSequence, "s");
        }
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$c */
    /* JADX INFO: compiled from: ChipsView.kt */
    public final class C5467c extends InputConnectionWrapper {
        public C5467c(InputConnection inputConnection) {
            super(inputConnection, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i) {
            C12238m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return super.commitText(charSequence, i);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (ChipsView.this.mEditText.length() == 0 && i == 1 && i2 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            C12238m.checkNotNullParameter(keyEvent, "event");
            if (ChipsView.this.mEditText.length() != 0 || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                return super.sendKeyEvent(keyEvent);
            }
            ChipsView chipsView = ChipsView.this;
            if (chipsView.mChipList.size() > 0) {
                try {
                    Iterator<Map.Entry<K, ViewOnClickListenerC0895a<K, V>>> it = chipsView.mChipList.entrySet().iterator();
                    ViewOnClickListenerC0895a<K, V> value = null;
                    while (it.hasNext()) {
                        value = it.next().getValue();
                    }
                    if (value != null) {
                        C12238m.checkNotNullParameter(value, "chip");
                        chipsView.m8380f(value);
                        if (value.f602k) {
                            chipsView.m8379e(value);
                        } else {
                            value.f602k = true;
                            chipsView.m8377c(false);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    Log.e("ChipsView", "Out of bounds", e);
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$d */
    /* JADX INFO: compiled from: ChipsView.kt */
    public static final class RunnableC5468d implements Runnable {
        public RunnableC5468d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView.this.fullScroll(130);
        }
    }

    /* JADX INFO: renamed from: com.discord.chips_view.ChipsView$e */
    /* JADX INFO: compiled from: ChipsView.kt */
    public static final class RunnableC5469e implements Runnable {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f15003k;

        public RunnableC5469e(boolean z2) {
            this.f15003k = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView chipsView = ChipsView.this;
            boolean z2 = this.f15003k;
            int i = ChipsView.f14975j;
            chipsView.m8377c(z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        this.mChipList = new LinkedHashMap<>();
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        this.mDensity = resources.getDisplayMetrics().density;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mChipsContainer = relativeLayout;
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        relativeLayout.addView(linearLayout);
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        C0898d c0898d = new C0898d(context2, this);
        this.mEditText = c0898d;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C5470R.c.ChipsView, 0, 0);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…tyleable.ChipsView, 0, 0)");
        try {
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_max_height, -1);
            this.mVerticalSpacingPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_vertical_spacing, (int) (1 * this.mDensity));
            this.mChipHeightPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_height, (int) (24 * this.mDensity));
            this.mChipsColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_color, ContextCompat.getColor(context, android.R.color.darker_gray));
            this.mChipsColorClicked = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_color_clicked, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_bg_color, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgResId = typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_chip_bg_res, 0);
            this.mChipsBgColorClicked = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_bg_color_clicked, ContextCompat.getColor(context, android.R.color.holo_blue_dark));
            this.mChipsTextColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsTextColorClicked = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_text_color_clicked, -1);
            this.mChipsHintRes = typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_hint, 0);
            typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_icon_placeholder, 0);
            this.mChipsSearchTextColor = typedArrayObtainStyledAttributes.getColor(C5470R.c.ChipsView_cv_search_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsSearchTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5470R.c.ChipsView_cv_search_text_size, 49);
            this.mChipLayout = typedArrayObtainStyledAttributes.getResourceId(C5470R.c.ChipsView_cv_chip_layout, C5470R.b.view_chip_default);
            typedArrayObtainStyledAttributes.recycle();
            int i = this.mChipHeightPx + this.mVerticalSpacingPx;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            float f = 4;
            layoutParams.leftMargin = (int) (this.mDensity * f);
            layoutParams.addRule(12, -1);
            c0898d.setLayoutParams(layoutParams);
            c0898d.setPadding(0, 0, 0, this.mVerticalSpacingPx);
            c0898d.setBackgroundColor(Color.argb(0, 0, 0, 0));
            c0898d.setImeOptions(268435456);
            c0898d.setInputType(1);
            c0898d.setTextColor(this.mChipsSearchTextColor);
            c0898d.setTextSize(0, this.mChipsSearchTextSize);
            relativeLayout.addView(c0898d);
            Context context3 = getContext();
            C12238m.checkNotNullExpressionValue(context3, "context");
            C0899e c0899e = new C0899e(context3, i);
            c0899e.setOrientation(1);
            c0899e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c0899e.setPadding(0, (int) (f * this.mDensity), 0, 0);
            this.mRootChipsLayout = c0899e;
            relativeLayout.addView(c0899e);
            relativeLayout.setOnClickListener(new ViewOnClickListenerC0901g(this));
            c0898d.addTextChangedListener(new C5466b());
            c0898d.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0900f(this));
            m8377c(false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // p007b.p008a.p021f.C0898d.a
    /* JADX INFO: renamed from: a */
    public InputConnection mo187a(InputConnection target) {
        return new C5467c(target);
    }

    /* JADX INFO: renamed from: b */
    public final void m8376b(String displayName, String imageContentDescription, K key, V data) {
        if (this.mChipList.containsKey(key)) {
            return;
        }
        this.mEditText.setText("");
        ViewOnClickListenerC0895a<K, V> viewOnClickListenerC0895a = new ViewOnClickListenerC0895a<>(displayName, imageContentDescription, key, data, new ViewOnClickListenerC0895a.a(this.mChipsBgColorClicked, this.mDensity, this.mChipsBgResId, this.mChipsBgColor, this.mChipsTextColor, this.mChipsTextColorClicked, this.mChipsColorClicked, this.mChipsColor, this.mChipHeightPx, this.mChipLayout), this);
        Editable text = this.mEditText.getText();
        if (text != null) {
            Object obj = this.mCurrentEditTextSpan;
            if (obj != null) {
                text.removeSpan(obj);
            }
            text.setSpan(this.mCurrentEditTextSpan, 0, 0, 17);
        }
        this.mEditText.setText(text);
        this.mChipList.put(key, viewOnClickListenerC0895a);
        Function1<? super V, Unit> function1 = this.chipAddedListener;
        if (function1 != null) {
            function1.invoke((Object) viewOnClickListenerC0895a.f606o);
        }
        m8377c(true);
        post(new RunnableC5468d());
    }

    /* JADX INFO: renamed from: c */
    public final void m8377c(boolean moveCursor) {
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
        C0899e c0899e = this.mRootChipsLayout;
        C0899e.a aVar = null;
        if (c0899e != null) {
            Collection<ViewOnClickListenerC0895a<K, V>> collectionValues = this.mChipList.values();
            C12238m.checkNotNullExpressionValue(collectionValues, "mChipList.values");
            C12238m.checkNotNullParameter(collectionValues, "chips");
            Iterator<LinearLayout> it = c0899e.f618j.iterator();
            while (it.hasNext()) {
                it.next().removeAllViews();
            }
            c0899e.f618j.clear();
            c0899e.removeAllViews();
            int width = c0899e.getWidth();
            if (width != 0) {
                LinearLayout linearLayoutM188a = c0899e.m188a();
                int i = 0;
                int i2 = 0;
                for (ViewOnClickListenerC0895a<K, V> viewOnClickListenerC0895a : collectionValues) {
                    if (viewOnClickListenerC0895a.f601j == null) {
                        View viewInflate = LayoutInflater.from(viewOnClickListenerC0895a.f608q.getContext()).inflate(C5470R.b.view_chip_default, (ViewGroup) null, false);
                        int i3 = C5470R.a.chip_image;
                        ImageView imageView2 = (ImageView) viewInflate.findViewById(i3);
                        if (imageView2 != null) {
                            i3 = C5470R.a.chip_text;
                            TextView textView5 = (TextView) viewInflate.findViewById(i3);
                            if (textView5 != null) {
                                viewOnClickListenerC0895a.f601j = new C0902a((RelativeLayout) viewInflate, imageView2, textView5);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, viewOnClickListenerC0895a.f607p.f614f);
                                C0902a c0902a = viewOnClickListenerC0895a.f601j;
                                if (c0902a != null && (relativeLayout4 = c0902a.f623a) != null) {
                                    relativeLayout4.setLayoutParams(layoutParams);
                                }
                                C0902a c0902a2 = viewOnClickListenerC0895a.f601j;
                                if (c0902a2 != null && (relativeLayout3 = c0902a2.f623a) != null) {
                                    relativeLayout3.setBackgroundResource(viewOnClickListenerC0895a.f607p.f610b);
                                    relativeLayout3.post(new RunnableC0896b(relativeLayout3, viewOnClickListenerC0895a));
                                    relativeLayout3.setOnClickListener(viewOnClickListenerC0895a);
                                }
                                C0902a c0902a3 = viewOnClickListenerC0895a.f601j;
                                if (c0902a3 != null && (imageView = c0902a3.f624b) != null) {
                                    imageView.setOnClickListener(viewOnClickListenerC0895a);
                                    C12238m.checkNotNullExpressionValue(imageView, "it");
                                    imageView.setContentDescription(viewOnClickListenerC0895a.f604m);
                                }
                                C0902a c0902a4 = viewOnClickListenerC0895a.f601j;
                                if (c0902a4 != null && (textView4 = c0902a4.f625c) != null) {
                                    textView4.setTextColor(viewOnClickListenerC0895a.f607p.f612d);
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
                    }
                    C0902a c0902a5 = viewOnClickListenerC0895a.f601j;
                    if (c0902a5 != null && (textView3 = c0902a5.f625c) != null) {
                        textView3.setText(viewOnClickListenerC0895a.f603l);
                    }
                    if (viewOnClickListenerC0895a.f602k) {
                        C0902a c0902a6 = viewOnClickListenerC0895a.f601j;
                        if (c0902a6 != null && (relativeLayout2 = c0902a6.f623a) != null && (background2 = relativeLayout2.getBackground()) != null) {
                            background2.setColorFilter(viewOnClickListenerC0895a.f607p.f609a, PorterDuff.Mode.SRC_ATOP);
                        }
                        C0902a c0902a7 = viewOnClickListenerC0895a.f601j;
                        if (c0902a7 != null && (textView2 = c0902a7.f625c) != null) {
                            textView2.setTextColor(viewOnClickListenerC0895a.f607p.f613e);
                        }
                    } else {
                        C0902a c0902a8 = viewOnClickListenerC0895a.f601j;
                        if (c0902a8 != null && (relativeLayout = c0902a8.f623a) != null && (background = relativeLayout.getBackground()) != null) {
                            background.setColorFilter(viewOnClickListenerC0895a.f607p.f611c, PorterDuff.Mode.SRC_ATOP);
                        }
                        C0902a c0902a9 = viewOnClickListenerC0895a.f601j;
                        if (c0902a9 != null && (textView = c0902a9.f625c) != null) {
                            textView.setTextColor(viewOnClickListenerC0895a.f607p.f612d);
                        }
                    }
                    C0902a c0902a10 = viewOnClickListenerC0895a.f601j;
                    RelativeLayout relativeLayout5 = c0902a10 != null ? c0902a10.f623a : null;
                    C12238m.checkNotNull(relativeLayout5);
                    relativeLayout5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (relativeLayout5.getMeasuredWidth() + i > width) {
                        i2++;
                        linearLayoutM188a = c0899e.m188a();
                        i = 0;
                    }
                    int measuredWidth = relativeLayout5.getMeasuredWidth();
                    ViewGroup.LayoutParams layoutParams2 = relativeLayout5.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    i += measuredWidth + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    linearLayoutM188a.addView(relativeLayout5);
                }
                if (width - i < width * 0.15f) {
                    i2++;
                    c0899e.m188a();
                    i = 0;
                }
                aVar = new C0899e.a(i2, i);
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
        if (aVar == null) {
            post(new RunnableC5469e(moveCursor));
            return;
        }
        int i5 = aVar.f620a;
        Editable text = this.mEditText.getText();
        Object obj = this.mCurrentEditTextSpan;
        if (obj != null && text != null) {
            text.removeSpan(obj);
        }
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(i5, 0);
        this.mCurrentEditTextSpan = standard;
        if (text != null) {
            text.setSpan(standard, 0, 0, 17);
        }
        this.mEditText.setText(text);
        if (moveCursor) {
            C0898d c0898d = this.mEditText;
            c0898d.setSelection(c0898d.length());
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8378d(Collection<?> pruneData) {
        C12238m.checkNotNullParameter(pruneData, "pruneData");
        Iterator<Map.Entry<K, ViewOnClickListenerC0895a<K, V>>> it = this.mChipList.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (!C12163u.contains(pruneData, it.next().getKey())) {
                it.remove();
                z2 = true;
            }
        }
        if (z2) {
            m8377c(true);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m8379e(ViewOnClickListenerC0895a<K, V> chip) {
        this.mChipList.remove(chip.f605n);
        Function1<? super V, Unit> function1 = this.chipDeletedListener;
        if (function1 != null) {
            function1.invoke((Object) chip.f606o);
        }
        m8377c(true);
    }

    /* JADX INFO: renamed from: f */
    public final void m8380f(ViewOnClickListenerC0895a<?, ?> rootChip) {
        for (ViewOnClickListenerC0895a<K, V> viewOnClickListenerC0895a : this.mChipList.values()) {
            if (viewOnClickListenerC0895a != rootChip) {
                viewOnClickListenerC0895a.f602k = false;
            }
        }
        m8377c(false);
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
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE));
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
        C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.mEditText.setText(str);
    }

    public final void setTextChangedListener(Function1<? super CharSequence, Unit> function1) {
        this.textChangedListener = function1;
    }
}
