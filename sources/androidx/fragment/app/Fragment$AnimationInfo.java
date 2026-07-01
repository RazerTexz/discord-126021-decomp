package androidx.fragment.app;

import android.animation.Animator;
import android.view.View;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$AnimationInfo {
    public Boolean mAllowEnterTransitionOverlap;
    public Boolean mAllowReturnTransitionOverlap;
    public View mAnimatingAway;
    public Animator mAnimator;
    public Object mEnterTransition = null;
    public SharedElementCallback mEnterTransitionCallback;
    public boolean mEnterTransitionPostponed;
    public Object mExitTransition;
    public SharedElementCallback mExitTransitionCallback;
    public View mFocusedView;
    public boolean mIsHideReplaced;
    public int mNextAnim;
    public int mNextTransition;
    public float mPostOnViewCreatedAlpha;
    public Object mReenterTransition;
    public Object mReturnTransition;
    public Object mSharedElementEnterTransition;
    public Object mSharedElementReturnTransition;
    public ArrayList<String> mSharedElementSourceNames;
    public ArrayList<String> mSharedElementTargetNames;
    public Fragment$OnStartEnterTransitionListener mStartEnterTransitionListener;

    public Fragment$AnimationInfo() {
        Object obj = Fragment.USE_DEFAULT_TRANSITION;
        this.mReturnTransition = obj;
        this.mExitTransition = null;
        this.mReenterTransition = obj;
        this.mSharedElementEnterTransition = null;
        this.mSharedElementReturnTransition = obj;
        this.mEnterTransitionCallback = null;
        this.mExitTransitionCallback = null;
        this.mPostOnViewCreatedAlpha = 1.0f;
        this.mFocusedView = null;
    }
}
