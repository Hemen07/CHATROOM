package redfox.chatroom.util.common_util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import redfox.chatroom.R;


public class UtilSnackBarProfile {

    private final static String TAG = UtilSnackBarProfile.class.getSimpleName();
    private final static boolean LOG_DEBUG = true;


    public static void snackBarProfile(Context context, String message) {
        if (LOG_DEBUG) Log.w(TAG, "snackBarProfile()");

        if (context != null) {

            switch (message) {
                case UtilConstant.USERNAME_EMPTY:
                    styleSnackBar(message, context, ContextCompat.getColor(context, R.color.snackbar_username_check)
                            , Color.BLACK);
                    break;
                case UtilConstant.USERNAME_INVALID:
                    styleSnackBar(message, context, ContextCompat.getColor(context, R.color.snackbar_username_check)
                            , Color.BLACK);
                    break;
                default:
                    break;
            }
        }
    }

    private static void styleSnackBar(String message, Context context, int backgroundColor, int textColor) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ((Activity) context).findViewById(R.id.Profile_coordinator);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT);

        View view = snackbar.getView();
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        Typeface typeface = ResourcesCompat.getFont(context, R.font.caviar_dreams);

        view.setBackgroundColor(backgroundColor);
        textView.setTextColor(textColor);
        textView.setTextSize(14);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTypeface(typeface);
        snackbar.show();

    }

}
