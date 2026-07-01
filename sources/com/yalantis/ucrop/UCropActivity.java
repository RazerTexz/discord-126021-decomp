package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.PorterDuff$Mode;
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
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout$LayoutParams;
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
import b.q.a.b;
import b.q.a.c;
import b.q.a.d;
import b.q.a.e;
import b.q.a.f;
import b.q.a.g;
import b.q.a.j.a;
import b.q.a.l.c$a;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity extends AppCompatActivity {
    public static final Bitmap$CompressFormat j = Bitmap$CompressFormat.JPEG;
    public ViewGroup A;
    public ViewGroup B;
    public ViewGroup C;
    public ViewGroup D;
    public TextView F;
    public TextView G;
    public View H;
    public Transition I;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;

    @ColorInt
    public int p;

    @DrawableRes
    public int q;

    @DrawableRes
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3178s;
    public boolean t;
    public UCropView v;
    public GestureCropImageView w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OverlayView f3179x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewGroup f3180y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewGroup f3181z;
    public boolean u = true;
    public List<ViewGroup> E = new ArrayList();
    public Bitmap$CompressFormat J = j;
    public int K = 90;
    public int[] L = {1, 2, 3};
    public c$a M = new UCropActivity$a(this);
    public final View$OnClickListener N = new UCropActivity$b(this);

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public final void a(int i) {
        GestureCropImageView gestureCropImageView = this.w;
        int[] iArr = this.L;
        gestureCropImageView.setScaleEnabled(iArr[i] == 3 || iArr[i] == 1);
        GestureCropImageView gestureCropImageView2 = this.w;
        int[] iArr2 = this.L;
        gestureCropImageView2.setRotateEnabled(iArr2[i] == 3 || iArr2[i] == 2);
    }

    public void b(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    public final void c(@IdRes int i) {
        if (this.t) {
            ViewGroup viewGroup = this.f3180y;
            int i2 = R$d.state_aspect_ratio;
            viewGroup.setSelected(i == i2);
            ViewGroup viewGroup2 = this.f3181z;
            int i3 = R$d.state_rotate;
            viewGroup2.setSelected(i == i3);
            ViewGroup viewGroup3 = this.A;
            int i4 = R$d.state_scale;
            viewGroup3.setSelected(i == i4);
            this.B.setVisibility(i == i2 ? 0 : 8);
            this.C.setVisibility(i == i3 ? 0 : 8);
            this.D.setVisibility(i == i4 ? 0 : 8);
            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R$d.ucrop_photobox), this.I);
            this.A.findViewById(R$d.text_view_scale).setVisibility(i == i4 ? 0 : 8);
            this.f3180y.findViewById(R$d.text_view_crop).setVisibility(i == i2 ? 0 : 8);
            this.f3181z.findViewById(R$d.text_view_rotate).setVisibility(i == i3 ? 0 : 8);
            if (i == i4) {
                a(0);
            } else if (i == i3) {
                a(1);
            } else {
                a(2);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$e.ucrop_activity_photobox);
        Intent intent = getIntent();
        this.m = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, R$a.ucrop_color_statusbar));
        this.l = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, R$a.ucrop_color_toolbar));
        this.n = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(this, R$a.ucrop_color_active_controls_color));
        this.o = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, R$a.ucrop_color_toolbar_widget));
        this.q = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R$c.ucrop_ic_cross);
        this.r = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R$c.ucrop_ic_done);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.k = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R$g.ucrop_label_edit_photo);
        }
        this.k = stringExtra;
        this.f3178s = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(this, R$a.ucrop_color_default_logo));
        this.t = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.p = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(this, R$a.ucrop_color_crop_background));
        int i = this.m;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
        Toolbar toolbar = (Toolbar) findViewById(R$d.toolbar);
        toolbar.setBackgroundColor(this.l);
        toolbar.setTitleTextColor(this.o);
        TextView textView = (TextView) toolbar.findViewById(R$d.toolbar_title);
        textView.setTextColor(this.o);
        textView.setText(this.k);
        Drawable drawableMutate = ContextCompat.getDrawable(this, this.q).mutate();
        drawableMutate.setColorFilter(this.o, PorterDuff$Mode.SRC_ATOP);
        toolbar.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        UCropView uCropView = (UCropView) findViewById(R$d.ucrop);
        this.v = uCropView;
        this.w = uCropView.getCropImageView();
        this.f3179x = this.v.getOverlayView();
        this.w.setTransformImageListener(this.M);
        ((ImageView) findViewById(R$d.image_view_logo)).setColorFilter(this.f3178s, PorterDuff$Mode.SRC_ATOP);
        int i2 = R$d.ucrop_frame;
        findViewById(i2).setBackgroundColor(this.p);
        if (!this.t) {
            ((RelativeLayout$LayoutParams) findViewById(i2).getLayoutParams()).bottomMargin = 0;
            findViewById(i2).requestLayout();
        }
        ViewGroup viewGroup = null;
        if (this.t) {
            ViewGroup viewGroup2 = (ViewGroup) ((ViewGroup) findViewById(R$d.ucrop_photobox)).findViewById(R$d.controls_wrapper);
            viewGroup2.setVisibility(0);
            LayoutInflater.from(this).inflate(R$e.ucrop_controls, viewGroup2, true);
            AutoTransition autoTransition = new AutoTransition();
            this.I = autoTransition;
            autoTransition.setDuration(50L);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R$d.state_aspect_ratio);
            this.f3180y = viewGroup3;
            viewGroup3.setOnClickListener(this.N);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R$d.state_rotate);
            this.f3181z = viewGroup4;
            viewGroup4.setOnClickListener(this.N);
            ViewGroup viewGroup5 = (ViewGroup) findViewById(R$d.state_scale);
            this.A = viewGroup5;
            viewGroup5.setOnClickListener(this.N);
            int i3 = R$d.layout_aspect_ratio;
            this.B = (ViewGroup) findViewById(i3);
            this.C = (ViewGroup) findViewById(R$d.layout_rotate_wheel);
            this.D = (ViewGroup) findViewById(R$d.layout_scale_wheel);
            int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
            ArrayList<AspectRatio> parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                parcelableArrayListExtra = new ArrayList();
                parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
                parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
                parcelableArrayListExtra.add(new AspectRatio(getString(R$g.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
                parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
                parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
                intExtra = 2;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(i3);
            LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(0, -1);
            linearLayout$LayoutParams.weight = 1.0f;
            for (AspectRatio aspectRatio : parcelableArrayListExtra) {
                FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R$e.ucrop_aspect_ratio, viewGroup);
                frameLayout.setLayoutParams(linearLayout$LayoutParams);
                AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
                aspectRatioTextView.setActiveColor(this.n);
                aspectRatioTextView.setAspectRatio(aspectRatio);
                linearLayout.addView(frameLayout);
                this.E.add(frameLayout);
                viewGroup = null;
            }
            this.E.get(intExtra).setSelected(true);
            Iterator<ViewGroup> it = this.E.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(new b(this));
            }
            this.F = (TextView) findViewById(R$d.text_view_rotate);
            int i4 = R$d.rotate_scroll_wheel;
            ((HorizontalProgressWheelView) findViewById(i4)).setScrollingListener(new c(this));
            ((HorizontalProgressWheelView) findViewById(i4)).setMiddleLineColor(this.n);
            findViewById(R$d.wrapper_reset_rotate).setOnClickListener(new d(this));
            findViewById(R$d.wrapper_rotate_by_angle).setOnClickListener(new e(this));
            int i5 = this.n;
            TextView textView2 = this.F;
            if (textView2 != null) {
                textView2.setTextColor(i5);
            }
            this.G = (TextView) findViewById(R$d.text_view_scale);
            int i6 = R$d.scale_scroll_wheel;
            ((HorizontalProgressWheelView) findViewById(i6)).setScrollingListener(new f(this));
            ((HorizontalProgressWheelView) findViewById(i6)).setMiddleLineColor(this.n);
            int i7 = this.n;
            TextView textView3 = this.G;
            if (textView3 != null) {
                textView3.setTextColor(i7);
            }
            ImageView imageView = (ImageView) findViewById(R$d.image_view_state_scale);
            ImageView imageView2 = (ImageView) findViewById(R$d.image_view_state_rotate);
            ImageView imageView3 = (ImageView) findViewById(R$d.image_view_state_aspect_ratio);
            imageView.setImageDrawable(new b.q.a.k.d(imageView.getDrawable(), this.n));
            imageView2.setImageDrawable(new b.q.a.k.d(imageView2.getDrawable(), this.n));
            imageView3.setImageDrawable(new b.q.a.k.d(imageView3.getDrawable(), this.n));
        }
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        String stringExtra2 = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap$CompressFormat bitmap$CompressFormatValueOf = !TextUtils.isEmpty(stringExtra2) ? Bitmap$CompressFormat.valueOf(stringExtra2) : null;
        if (bitmap$CompressFormatValueOf == null) {
            bitmap$CompressFormatValueOf = j;
        }
        this.J = bitmap$CompressFormatValueOf;
        this.K = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.L = intArrayExtra;
        }
        this.w.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.w.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.w.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.f3179x.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.f3179x.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R$a.ucrop_color_default_dimmed)));
        this.f3179x.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f3179x.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.f3179x.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R$a.ucrop_color_default_crop_frame)));
        this.f3179x.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R$b.ucrop_default_crop_frame_stoke_width)));
        this.f3179x.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.f3179x.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f3179x.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f3179x.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(R$a.ucrop_color_default_crop_grid)));
        this.f3179x.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R$b.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup6 = this.f3180y;
            if (viewGroup6 != null) {
                viewGroup6.setVisibility(8);
            }
            this.w.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra2 == null || intExtra2 >= parcelableArrayListExtra2.size()) {
            this.w.setTargetAspectRatio(0.0f);
        } else {
            this.w.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra2.get(intExtra2)).k / ((AspectRatio) parcelableArrayListExtra2.get(intExtra2)).l);
        }
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra4 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra3 > 0 && intExtra4 > 0) {
            this.w.setMaxResultImageSizeX(intExtra3);
            this.w.setMaxResultImageSizeY(intExtra4);
        }
        if (uri == null || uri2 == null) {
            b(new NullPointerException(getString(R$g.ucrop_error_input_data_is_absent)));
            finish();
        } else {
            try {
                GestureCropImageView gestureCropImageView = this.w;
                int maxBitmapSize = gestureCropImageView.getMaxBitmapSize();
                new b.q.a.j.b(gestureCropImageView.getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new b.q.a.l.b(gestureCropImageView)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e) {
                b(e);
                finish();
            }
        }
        if (!this.t) {
            a(0);
        } else if (this.f3180y.getVisibility() == 0) {
            c(R$d.state_aspect_ratio);
        } else {
            c(R$d.state_scale);
        }
        if (this.H == null) {
            this.H = new View(this);
            RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-1, -1);
            relativeLayout$LayoutParams.addRule(3, R$d.toolbar);
            this.H.setLayoutParams(relativeLayout$LayoutParams);
            this.H.setClickable(true);
        }
        ((RelativeLayout) findViewById(R$d.ucrop_photobox)).addView(this.H);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$f.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R$d.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.o, PorterDuff$Mode.SRC_ATOP);
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i("UCropActivity", String.format("%s - %s", e.getMessage(), getString(R$g.ucrop_mutate_exception_hint)));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R$d.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.r);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.o, PorterDuff$Mode.SRC_ATOP);
            menuItemFindItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R$d.menu_crop) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return true;
        }
        this.H.setClickable(true);
        this.u = true;
        supportInvalidateOptionsMenu();
        GestureCropImageView gestureCropImageView = this.w;
        Bitmap$CompressFormat bitmap$CompressFormat = this.J;
        int i = this.K;
        g gVar = new g(this);
        gestureCropImageView.i();
        gestureCropImageView.setImageToWrapCropBounds(false);
        new a(gestureCropImageView.getContext(), gestureCropImageView.getViewBitmap(), new b.q.a.i.c(gestureCropImageView.f1987y, b.i.a.f.e.o.f.y1(gestureCropImageView.j), gestureCropImageView.getCurrentScale(), gestureCropImageView.getCurrentAngle()), new b.q.a.i.a(gestureCropImageView.H, gestureCropImageView.I, bitmap$CompressFormat, i, gestureCropImageView.getImageInputPath(), gestureCropImageView.getImageOutputPath(), gestureCropImageView.getExifInfo()), gVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R$d.menu_crop).setVisible(!this.u);
        menu.findItem(R$d.menu_loader).setVisible(this.u);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.w;
        if (gestureCropImageView != null) {
            gestureCropImageView.i();
        }
    }
}
