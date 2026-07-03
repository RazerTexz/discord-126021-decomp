package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p485q.p486a.C5287c;
import p007b.p485q.p486a.C5290f;
import p007b.p485q.p486a.C5291g;
import p007b.p485q.p486a.ViewOnClickListenerC5286b;
import p007b.p485q.p486a.ViewOnClickListenerC5288d;
import p007b.p485q.p486a.ViewOnClickListenerC5289e;
import p007b.p485q.p486a.p488i.C5296a;
import p007b.p485q.p486a.p488i.C5298c;
import p007b.p485q.p486a.p489j.AsyncTaskC5299a;
import p007b.p485q.p486a.p489j.AsyncTaskC5300b;
import p007b.p485q.p486a.p490k.C5304d;
import p007b.p485q.p486a.p491l.C5306b;
import p007b.p485q.p486a.p491l.C5307c;

/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: j */
    public static final Bitmap.CompressFormat f22167j = Bitmap.CompressFormat.JPEG;

    /* JADX INFO: renamed from: A */
    public ViewGroup f22168A;

    /* JADX INFO: renamed from: B */
    public ViewGroup f22169B;

    /* JADX INFO: renamed from: C */
    public ViewGroup f22170C;

    /* JADX INFO: renamed from: D */
    public ViewGroup f22171D;

    /* JADX INFO: renamed from: F */
    public TextView f22173F;

    /* JADX INFO: renamed from: G */
    public TextView f22174G;

    /* JADX INFO: renamed from: H */
    public View f22175H;

    /* JADX INFO: renamed from: I */
    public Transition f22176I;

    /* JADX INFO: renamed from: k */
    public String f22182k;

    /* JADX INFO: renamed from: l */
    public int f22183l;

    /* JADX INFO: renamed from: m */
    public int f22184m;

    /* JADX INFO: renamed from: n */
    public int f22185n;

    /* JADX INFO: renamed from: o */
    public int f22186o;

    /* JADX INFO: renamed from: p */
    @ColorInt
    public int f22187p;

    /* JADX INFO: renamed from: q */
    @DrawableRes
    public int f22188q;

    /* JADX INFO: renamed from: r */
    @DrawableRes
    public int f22189r;

    /* JADX INFO: renamed from: s */
    public int f22190s;

    /* JADX INFO: renamed from: t */
    public boolean f22191t;

    /* JADX INFO: renamed from: v */
    public UCropView f22193v;

    /* JADX INFO: renamed from: w */
    public GestureCropImageView f22194w;

    /* JADX INFO: renamed from: x */
    public OverlayView f22195x;

    /* JADX INFO: renamed from: y */
    public ViewGroup f22196y;

    /* JADX INFO: renamed from: z */
    public ViewGroup f22197z;

    /* JADX INFO: renamed from: u */
    public boolean f22192u = true;

    /* JADX INFO: renamed from: E */
    public List<ViewGroup> f22172E = new ArrayList();

    /* JADX INFO: renamed from: J */
    public Bitmap.CompressFormat f22177J = f22167j;

    /* JADX INFO: renamed from: K */
    public int f22178K = 90;

    /* JADX INFO: renamed from: L */
    public int[] f22179L = {1, 2, 3};

    /* JADX INFO: renamed from: M */
    public C5307c.a f22180M = new C11200a();

    /* JADX INFO: renamed from: N */
    public final View.OnClickListener f22181N = new ViewOnClickListenerC11201b();

    /* JADX INFO: renamed from: com.yalantis.ucrop.UCropActivity$a */
    public class C11200a implements C5307c.a {
        public C11200a() {
        }

        /* JADX INFO: renamed from: a */
        public void m9322a(float f) {
            TextView textView = UCropActivity.this.f22173F;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
            }
        }

        /* JADX INFO: renamed from: b */
        public void m9323b(float f) {
            TextView textView = UCropActivity.this.f22174G;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
            }
        }
    }

    /* JADX INFO: renamed from: com.yalantis.ucrop.UCropActivity$b */
    public class ViewOnClickListenerC11201b implements View.OnClickListener {
        public ViewOnClickListenerC11201b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity uCropActivity = UCropActivity.this;
            int id2 = view.getId();
            Bitmap.CompressFormat compressFormat = UCropActivity.f22167j;
            uCropActivity.m9321c(id2);
        }
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX INFO: renamed from: a */
    public final void m9319a(int i) {
        GestureCropImageView gestureCropImageView = this.f22194w;
        int[] iArr = this.f22179L;
        gestureCropImageView.setScaleEnabled(iArr[i] == 3 || iArr[i] == 1);
        GestureCropImageView gestureCropImageView2 = this.f22194w;
        int[] iArr2 = this.f22179L;
        gestureCropImageView2.setRotateEnabled(iArr2[i] == 3 || iArr2[i] == 2);
    }

    /* JADX INFO: renamed from: b */
    public void m9320b(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    /* JADX INFO: renamed from: c */
    public final void m9321c(@IdRes int i) {
        if (this.f22191t) {
            ViewGroup viewGroup = this.f22196y;
            int i2 = C11199R.d.state_aspect_ratio;
            viewGroup.setSelected(i == i2);
            ViewGroup viewGroup2 = this.f22197z;
            int i3 = C11199R.d.state_rotate;
            viewGroup2.setSelected(i == i3);
            ViewGroup viewGroup3 = this.f22168A;
            int i4 = C11199R.d.state_scale;
            viewGroup3.setSelected(i == i4);
            this.f22169B.setVisibility(i == i2 ? 0 : 8);
            this.f22170C.setVisibility(i == i3 ? 0 : 8);
            this.f22171D.setVisibility(i == i4 ? 0 : 8);
            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(C11199R.d.ucrop_photobox), this.f22176I);
            this.f22168A.findViewById(C11199R.d.text_view_scale).setVisibility(i == i4 ? 0 : 8);
            this.f22196y.findViewById(C11199R.d.text_view_crop).setVisibility(i == i2 ? 0 : 8);
            this.f22197z.findViewById(C11199R.d.text_view_rotate).setVisibility(i == i3 ? 0 : 8);
            if (i == i4) {
                m9319a(0);
            } else if (i == i3) {
                m9319a(1);
            } else {
                m9319a(2);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C11199R.e.ucrop_activity_photobox);
        Intent intent = getIntent();
        this.f22184m = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, C11199R.a.ucrop_color_statusbar));
        this.f22183l = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, C11199R.a.ucrop_color_toolbar));
        this.f22185n = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(this, C11199R.a.ucrop_color_active_controls_color));
        this.f22186o = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, C11199R.a.ucrop_color_toolbar_widget));
        this.f22188q = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", C11199R.c.ucrop_ic_cross);
        this.f22189r = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", C11199R.c.ucrop_ic_done);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.f22182k = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(C11199R.g.ucrop_label_edit_photo);
        }
        this.f22182k = stringExtra;
        this.f22190s = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(this, C11199R.a.ucrop_color_default_logo));
        this.f22191t = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.f22187p = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(this, C11199R.a.ucrop_color_crop_background));
        int i = this.f22184m;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
        Toolbar toolbar = (Toolbar) findViewById(C11199R.d.toolbar);
        toolbar.setBackgroundColor(this.f22183l);
        toolbar.setTitleTextColor(this.f22186o);
        TextView textView = (TextView) toolbar.findViewById(C11199R.d.toolbar_title);
        textView.setTextColor(this.f22186o);
        textView.setText(this.f22182k);
        Drawable drawableMutate = ContextCompat.getDrawable(this, this.f22188q).mutate();
        drawableMutate.setColorFilter(this.f22186o, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        UCropView uCropView = (UCropView) findViewById(C11199R.d.ucrop);
        this.f22193v = uCropView;
        this.f22194w = uCropView.getCropImageView();
        this.f22195x = this.f22193v.getOverlayView();
        this.f22194w.setTransformImageListener(this.f22180M);
        ((ImageView) findViewById(C11199R.d.image_view_logo)).setColorFilter(this.f22190s, PorterDuff.Mode.SRC_ATOP);
        int i2 = C11199R.d.ucrop_frame;
        findViewById(i2).setBackgroundColor(this.f22187p);
        if (!this.f22191t) {
            ((RelativeLayout.LayoutParams) findViewById(i2).getLayoutParams()).bottomMargin = 0;
            findViewById(i2).requestLayout();
        }
        ViewGroup viewGroup = null;
        if (this.f22191t) {
            ViewGroup viewGroup2 = (ViewGroup) ((ViewGroup) findViewById(C11199R.d.ucrop_photobox)).findViewById(C11199R.d.controls_wrapper);
            viewGroup2.setVisibility(0);
            LayoutInflater.from(this).inflate(C11199R.e.ucrop_controls, viewGroup2, true);
            AutoTransition autoTransition = new AutoTransition();
            this.f22176I = autoTransition;
            autoTransition.setDuration(50L);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(C11199R.d.state_aspect_ratio);
            this.f22196y = viewGroup3;
            viewGroup3.setOnClickListener(this.f22181N);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(C11199R.d.state_rotate);
            this.f22197z = viewGroup4;
            viewGroup4.setOnClickListener(this.f22181N);
            ViewGroup viewGroup5 = (ViewGroup) findViewById(C11199R.d.state_scale);
            this.f22168A = viewGroup5;
            viewGroup5.setOnClickListener(this.f22181N);
            int i3 = C11199R.d.layout_aspect_ratio;
            this.f22169B = (ViewGroup) findViewById(i3);
            this.f22170C = (ViewGroup) findViewById(C11199R.d.layout_rotate_wheel);
            this.f22171D = (ViewGroup) findViewById(C11199R.d.layout_scale_wheel);
            int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
            ArrayList<AspectRatio> parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                parcelableArrayListExtra = new ArrayList();
                parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
                parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
                parcelableArrayListExtra.add(new AspectRatio(getString(C11199R.g.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
                parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
                parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
                intExtra = 2;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            for (AspectRatio aspectRatio : parcelableArrayListExtra) {
                FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(C11199R.e.ucrop_aspect_ratio, viewGroup);
                frameLayout.setLayoutParams(layoutParams);
                AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
                aspectRatioTextView.setActiveColor(this.f22185n);
                aspectRatioTextView.setAspectRatio(aspectRatio);
                linearLayout.addView(frameLayout);
                this.f22172E.add(frameLayout);
                viewGroup = null;
            }
            this.f22172E.get(intExtra).setSelected(true);
            Iterator<ViewGroup> it = this.f22172E.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(new ViewOnClickListenerC5286b(this));
            }
            this.f22173F = (TextView) findViewById(C11199R.d.text_view_rotate);
            int i4 = C11199R.d.rotate_scroll_wheel;
            ((HorizontalProgressWheelView) findViewById(i4)).setScrollingListener(new C5287c(this));
            ((HorizontalProgressWheelView) findViewById(i4)).setMiddleLineColor(this.f22185n);
            findViewById(C11199R.d.wrapper_reset_rotate).setOnClickListener(new ViewOnClickListenerC5288d(this));
            findViewById(C11199R.d.wrapper_rotate_by_angle).setOnClickListener(new ViewOnClickListenerC5289e(this));
            int i5 = this.f22185n;
            TextView textView2 = this.f22173F;
            if (textView2 != null) {
                textView2.setTextColor(i5);
            }
            this.f22174G = (TextView) findViewById(C11199R.d.text_view_scale);
            int i6 = C11199R.d.scale_scroll_wheel;
            ((HorizontalProgressWheelView) findViewById(i6)).setScrollingListener(new C5290f(this));
            ((HorizontalProgressWheelView) findViewById(i6)).setMiddleLineColor(this.f22185n);
            int i7 = this.f22185n;
            TextView textView3 = this.f22174G;
            if (textView3 != null) {
                textView3.setTextColor(i7);
            }
            ImageView imageView = (ImageView) findViewById(C11199R.d.image_view_state_scale);
            ImageView imageView2 = (ImageView) findViewById(C11199R.d.image_view_state_rotate);
            ImageView imageView3 = (ImageView) findViewById(C11199R.d.image_view_state_aspect_ratio);
            imageView.setImageDrawable(new C5304d(imageView.getDrawable(), this.f22185n));
            imageView2.setImageDrawable(new C5304d(imageView2.getDrawable(), this.f22185n));
            imageView3.setImageDrawable(new C5304d(imageView3.getDrawable(), this.f22185n));
        }
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        String stringExtra2 = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra2) ? Bitmap.CompressFormat.valueOf(stringExtra2) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = f22167j;
        }
        this.f22177J = compressFormatValueOf;
        this.f22178K = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.f22179L = intArrayExtra;
        }
        this.f22194w.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.f22194w.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.f22194w.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.f22195x.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.f22195x.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(C11199R.a.ucrop_color_default_dimmed)));
        this.f22195x.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f22195x.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.f22195x.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(C11199R.a.ucrop_color_default_crop_frame)));
        this.f22195x.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_frame_stoke_width)));
        this.f22195x.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.f22195x.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f22195x.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f22195x.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(C11199R.a.ucrop_color_default_crop_grid)));
        this.f22195x.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup6 = this.f22196y;
            if (viewGroup6 != null) {
                viewGroup6.setVisibility(8);
            }
            this.f22194w.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra2 == null || intExtra2 >= parcelableArrayListExtra2.size()) {
            this.f22194w.setTargetAspectRatio(0.0f);
        } else {
            this.f22194w.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra2.get(intExtra2)).f22201k / ((AspectRatio) parcelableArrayListExtra2.get(intExtra2)).f22202l);
        }
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra4 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra3 > 0 && intExtra4 > 0) {
            this.f22194w.setMaxResultImageSizeX(intExtra3);
            this.f22194w.setMaxResultImageSizeY(intExtra4);
        }
        if (uri == null || uri2 == null) {
            m9320b(new NullPointerException(getString(C11199R.g.ucrop_error_input_data_is_absent)));
            finish();
        } else {
            try {
                GestureCropImageView gestureCropImageView = this.f22194w;
                int maxBitmapSize = gestureCropImageView.getMaxBitmapSize();
                new AsyncTaskC5300b(gestureCropImageView.getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new C5306b(gestureCropImageView)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e) {
                m9320b(e);
                finish();
            }
        }
        if (!this.f22191t) {
            m9319a(0);
        } else if (this.f22196y.getVisibility() == 0) {
            m9321c(C11199R.d.state_aspect_ratio);
        } else {
            m9321c(C11199R.d.state_scale);
        }
        if (this.f22175H == null) {
            this.f22175H = new View(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, C11199R.d.toolbar);
            this.f22175H.setLayoutParams(layoutParams2);
            this.f22175H.setClickable(true);
        }
        ((RelativeLayout) findViewById(C11199R.d.ucrop_photobox)).addView(this.f22175H);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C11199R.f.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(C11199R.d.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.f22186o, PorterDuff.Mode.SRC_ATOP);
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i("UCropActivity", String.format("%s - %s", e.getMessage(), getString(C11199R.g.ucrop_mutate_exception_hint)));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(C11199R.d.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.f22189r);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.f22186o, PorterDuff.Mode.SRC_ATOP);
            menuItemFindItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C11199R.d.menu_crop) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return true;
        }
        this.f22175H.setClickable(true);
        this.f22192u = true;
        supportInvalidateOptionsMenu();
        GestureCropImageView gestureCropImageView = this.f22194w;
        Bitmap.CompressFormat compressFormat = this.f22177J;
        int i = this.f22178K;
        C5291g c5291g = new C5291g(this);
        gestureCropImageView.m7480i();
        gestureCropImageView.setImageToWrapCropBounds(false);
        new AsyncTaskC5299a(gestureCropImageView.getContext(), gestureCropImageView.getViewBitmap(), new C5298c(gestureCropImageView.f14464y, C3404f.m4365y1(gestureCropImageView.f14484j), gestureCropImageView.getCurrentScale(), gestureCropImageView.getCurrentAngle()), new C5296a(gestureCropImageView.f14461H, gestureCropImageView.f14462I, compressFormat, i, gestureCropImageView.getImageInputPath(), gestureCropImageView.getImageOutputPath(), gestureCropImageView.getExifInfo()), c5291g).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(C11199R.d.menu_crop).setVisible(!this.f22192u);
        menu.findItem(C11199R.d.menu_loader).setVisible(this.f22192u);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.f22194w;
        if (gestureCropImageView != null) {
            gestureCropImageView.m7480i();
        }
    }
}
