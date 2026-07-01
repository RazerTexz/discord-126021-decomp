package b.b.a.d;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.e.ViewGridImageBinding;
import com.discord.utilities.time.TimeUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.b.a.d.h, reason: use source file name */
/* JADX INFO: compiled from: MediaCursorAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaCursorAdapter extends RecyclerView.Adapter<a> {
    public final SelectionCoordinator<?, Media> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cursor f319b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Integer g;
    public final int h;
    public final int i;

    /* JADX INFO: renamed from: b.b.a.d.h$a */
    /* JADX INFO: compiled from: MediaCursorAdapter.kt */
    public final class a extends ThumbnailViewHolder implements View.OnClickListener {
        public Media p;
        public final AnimatorSet q;
        public final AnimatorSet r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final ViewGridImageBinding f320s;
        public final /* synthetic */ MediaCursorAdapter t;

        /* JADX INFO: renamed from: b.b.a.d.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaCursorAdapter.kt */
        public static final class C0024a extends Lambda implements Function1<AnimatorSet, Unit> {
            public final /* synthetic */ boolean $isAnimationRequested;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0024a(boolean z2) {
                super(1);
                this.$isAnimationRequested = z2;
            }

            public final void a(AnimatorSet animatorSet) {
                Intrinsics3.checkNotNullParameter(animatorSet, "animation");
                animatorSet.start();
                if (this.$isAnimationRequested) {
                    return;
                }
                animatorSet.end();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimatorSet animatorSet) {
                a(animatorSet);
                return Unit.a;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(MediaCursorAdapter mediaCursorAdapter, ViewGridImageBinding viewGridImageBinding) {
            Intrinsics3.checkNotNullParameter(viewGridImageBinding, "binding");
            this.t = mediaCursorAdapter;
            FrameLayout frameLayout = viewGridImageBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout);
            this.f320s = viewGridImageBinding;
            viewGridImageBinding.a.setOnClickListener(this);
            FrameLayout frameLayout2 = viewGridImageBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.root");
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(frameLayout2.getContext(), R.a.selection_shrink);
            Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            this.q = animatorSet;
            animatorSet.setTarget(viewGridImageBinding.f324b);
            FrameLayout frameLayout3 = viewGridImageBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.root");
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(frameLayout3.getContext(), R.a.selection_grow);
            Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            this.r = animatorSet2;
            animatorSet2.setTarget(viewGridImageBinding.f324b);
        }

        @Override // b.b.a.d.ThumbnailViewHolder
        public SimpleDraweeView a() {
            SimpleDraweeView simpleDraweeView = this.f320s.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
            return simpleDraweeView;
        }

        public final void d(boolean z2, boolean z3) {
            FrameLayout frameLayout = this.f320s.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            frameLayout.setSelected(z2);
            C0024a c0024a = new C0024a(z3);
            if (z2) {
                SimpleDraweeView simpleDraweeView = this.f320s.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemCheckIndicator");
                simpleDraweeView.setVisibility(0);
                FrameLayout frameLayout2 = this.f320s.f324b;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.contentContainer");
                if (frameLayout2.getScaleX() == 1.0f) {
                    c0024a.a(this.q);
                    return;
                }
                return;
            }
            SimpleDraweeView simpleDraweeView2 = this.f320s.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemCheckIndicator");
            simpleDraweeView2.setVisibility(8);
            FrameLayout frameLayout3 = this.f320s.f324b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.contentContainer");
            if (frameLayout3.getScaleX() != 1.0f) {
                c0024a.a(this.r);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics3.checkNotNullParameter(view, "v");
            SelectionCoordinator<?, Media> selectionCoordinator = this.t.a;
            Media media = this.p;
            int adapterPosition = getAdapterPosition();
            Objects.requireNonNull(selectionCoordinator);
            if (media == null || selectionCoordinator.d(media)) {
                return;
            }
            selectionCoordinator.c(media, adapterPosition);
        }
    }

    /* JADX INFO: renamed from: b.b.a.d.h$b */
    /* JADX INFO: compiled from: MediaCursorAdapter.kt */
    public static final class b extends AsyncQueryHandler {
        public b(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            Intrinsics3.checkNotNullParameter(obj, "cookie");
            if (cursor == null) {
                return;
            }
            MediaCursorAdapter mediaCursorAdapter = MediaCursorAdapter.this;
            mediaCursorAdapter.c = cursor.getColumnIndex("_id");
            mediaCursorAdapter.d = cursor.getColumnIndex("_data");
            mediaCursorAdapter.e = cursor.getColumnIndex("_display_name");
            mediaCursorAdapter.f = cursor.getColumnIndex("media_type");
            if (Build.VERSION.SDK_INT >= 29) {
                mediaCursorAdapter.g = Integer.valueOf(cursor.getColumnIndex("duration"));
            }
            mediaCursorAdapter.f319b = cursor;
            MediaCursorAdapter.this.notifyDataSetChanged();
        }
    }

    public MediaCursorAdapter(SelectionCoordinator<?, Media> selectionCoordinator, int i, int i2) {
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.h = i;
        this.i = i2;
        Objects.requireNonNull(selectionCoordinator);
        Intrinsics3.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.a = selectionCoordinator;
        setHasStableIds(true);
    }

    public final Media a(int i) {
        String str;
        Cursor cursor = this.f319b;
        Media media = null;
        lValueOf = null;
        Long lValueOf = null;
        if (cursor != null) {
            cursor.moveToPosition(i);
            long j = cursor.getLong(this.c);
            boolean z2 = cursor.getInt(this.f) == 3;
            Uri uriWithAppendedPath = z2 ? Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)) : Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(j));
            String str2 = z2 ? "vid" : "img";
            Integer num = this.g;
            if (z2 && num != null) {
                lValueOf = Long.valueOf(cursor.getLong(num.intValue()));
            }
            Long l = lValueOf;
            Intrinsics3.checkNotNullExpressionValue(uriWithAppendedPath, "fileUri");
            String string = cursor.getString(this.e);
            if (string != null) {
                str = string;
            } else {
                str = str2 + '-' + j;
            }
            media = new Media(j, uriWithAppendedPath, str, cursor.getString(this.d), z2, l);
        }
        return media;
    }

    public final void b(ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        int i = Build.VERSION.SDK_INT;
        String str = i >= 29 ? "media_type = 1 OR media_type = 3" : "media_type = 1";
        new b(contentResolver).startQuery(1, this, MediaStore.Files.getContentUri("external"), i >= 29 ? new String[]{"_id", "_data", "_display_name", "media_type", "duration"} : new String[]{"_id", "_data", "_display_name", "media_type"}, str, null, "date_added DESC");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        Cursor cursor = this.f319b;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Media mediaA = a(i);
        if (mediaA != null) {
            return mediaA.getId();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recyclerView.context");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "recyclerView.context.contentResolver");
        b(contentResolver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws IOException {
        Long l;
        a aVar = (a) viewHolder;
        Intrinsics3.checkNotNullParameter(aVar, "holder");
        Media mediaA = a(i);
        aVar.p = mediaA;
        FrameLayout frameLayout = aVar.f320s.a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        Context context = frameLayout.getContext();
        if (mediaA != null) {
            aVar.d(aVar.t.a.a(mediaA, aVar.getAdapterPosition()), false);
        }
        aVar.c(mediaA, Integer.valueOf(aVar.t.h), Integer.valueOf(aVar.t.i));
        boolean z2 = mediaA != null && mediaA.j;
        TextView textView = aVar.f320s.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemVideoIndicator");
        textView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView2 = aVar.f320s.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemVideoIndicator");
            Drawable background = textView2.getBackground();
            Intrinsics3.checkNotNullExpressionValue(background, "binding.itemVideoIndicator.background");
            background.setAlpha(Opcodes.LAND);
            long jLongValue = (mediaA == null || (l = mediaA.k) == null) ? 0L : l.longValue();
            TextView textView3 = aVar.f320s.e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemVideoIndicator");
            textView3.setText(jLongValue > 0 ? TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null) : context.getString(R.h.video));
        }
        SimpleDraweeView simpleDraweeView = aVar.f320s.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
        simpleDraweeView.setContentDescription(context.getString(z2 ? R.h.video : R.h.image));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.g.view_grid_image, viewGroup, false);
        int i2 = R.f.content_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(i2);
        if (frameLayout != null) {
            i2 = R.f.content_iv;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView != null) {
                i2 = R.f.item_check_indicator;
                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView2 != null) {
                    i2 = R.f.item_video_indicator;
                    TextView textView = (TextView) viewInflate.findViewById(i2);
                    if (textView != null) {
                        ViewGridImageBinding viewGridImageBinding = new ViewGridImageBinding((FrameLayout) viewInflate, frameLayout, simpleDraweeView, simpleDraweeView2, textView);
                        Intrinsics3.checkNotNullExpressionValue(viewGridImageBinding, "ViewGridImageBinding.inf….context), parent, false)");
                        return new a(this, viewGridImageBinding);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Cursor cursor = this.f319b;
        if (cursor != null) {
            cursor.close();
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) viewHolder;
        Intrinsics3.checkNotNullParameter(aVar, "holder");
        super.onViewRecycled(aVar);
        aVar.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        Object next;
        a aVar = (a) viewHolder;
        Intrinsics3.checkNotNullParameter(aVar, "holder");
        Intrinsics3.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof SelectionCoordinator.a));
        if (next != null) {
            SelectionCoordinator.a aVar2 = (SelectionCoordinator.a) (next instanceof SelectionCoordinator.a ? next : null);
            if (aVar2 != null) {
                aVar.d(aVar2.f3171b, true);
                return;
            }
        }
        super.onBindViewHolder(aVar, i, list);
    }
}
