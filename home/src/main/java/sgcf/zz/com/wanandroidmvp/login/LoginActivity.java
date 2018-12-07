package sgcf.zz.com.wanandroidmvp.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import sgcf.zz.com.wanandroidmvp.R;
import sgcf.zz.com.wanandroidmvp.mvp.BaseMvpActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView {


    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.user_name)
    AutoCompleteTextView userName;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        final String user_name = userName.getText().toString();
        final String pass_word = password.getText().toString();
        if (TextUtils.isEmpty(user_name) || TextUtils.isEmpty(pass_word)) {
            Toast.makeText(this, "账号或者密码为空!", Toast.LENGTH_SHORT).show();
        }

        emailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPresenter != null) {
                    mPresenter.login(user_name,pass_word);
                }
            }
        });
    }


    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoginError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this);
//    }
}

