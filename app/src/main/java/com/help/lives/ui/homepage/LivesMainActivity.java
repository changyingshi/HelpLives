package com.help.lives.ui.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.help.lives.R;
import com.help.lives.ui.base.BaseActivity;
import com.help.lives.ui.fragment.CategoryFragment;
import com.help.lives.ui.fragment.HomePageFragment;
import com.help.lives.ui.fragment.KnowledgeFragment;
import com.help.lives.ui.fragment.PersonCenterFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LivesMainActivity extends BaseActivity {

    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.image_homepage)
    ImageView imageHomepage;
    @Bind(R.id.text_homepage)
    TextView textHomepage;
    @Bind(R.id.tab_homepage_layout)
    RelativeLayout tabHomepageLayout;
    @Bind(R.id.image_knowledge)
    ImageView imageKnowledge;
    @Bind(R.id.text_knowledge)
    TextView textKnowledge;
    @Bind(R.id.tab_knowledge_layout)
    RelativeLayout tabKnowledgeLayout;
    @Bind(R.id.image_category)
    ImageView imageCategory;
    @Bind(R.id.text_category)
    TextView textCategory;
    @Bind(R.id.tab_category_layout)
    RelativeLayout tabCategoryLayout;
    @Bind(R.id.image_person)
    ImageView imagePerson;
    @Bind(R.id.text_person)
    TextView textPerson;
    @Bind(R.id.tab_person_layout)
    RelativeLayout tabPersonLayout;

    /**
     * 首页Fragment
     */
    private HomePageFragment mHomepageFragment;

    /**
     * 求知Fragment
     */
    private KnowledgeFragment mKnowledgeFragment;

    /**
     * 项目分类Fragment
     */
    private CategoryFragment mCategoryFragment;

    /**
     * 我的个人中心Fragment
     */
    private PersonCenterFragment mPersonCenterFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lives_main);
        ButterKnife.bind(this);
        //第一次初始化首页默认显示第一个fragment
        setTabSelection(0);
    }

    @Override
    protected void initData()
    {

    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     * @param index
     */
    private void setTabSelection(int index)
    {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        //开启事务，Fragment的控制是有事务实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragment(transaction);
        switch (index)
        {
            case 0:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                setTextColor(textHomepage, R.color.tab_text_selector);
                imageHomepage.setImageResource(R.mipmap.tab_homepage_selected);
                //初始化Fragment
                if (mHomepageFragment == null)
                {
                    mHomepageFragment = new HomePageFragment();
                    transaction.add(R.id.content, mHomepageFragment);
                }
                else
                {
                    transaction.show(mHomepageFragment);
                }
                break;
            case 1:
                setTextColor(textKnowledge, R.color.tab_text_selector);
                imageKnowledge.setImageResource(R.mipmap.tab_knowledge_selected);
                if (mKnowledgeFragment == null)
                {
                    mKnowledgeFragment = new KnowledgeFragment();
                    transaction.add(R.id.content, mKnowledgeFragment);
                }
                else
                {
                    transaction.show(mKnowledgeFragment);
                }
                break;
            case 2:
                setTextColor(textCategory, R.color.tab_text_selector);
                imageCategory.setImageResource(R.mipmap.tab_category_selected);
                if (mCategoryFragment == null)
                {
                    mCategoryFragment = new CategoryFragment();
                    transaction.add(R.id.content, mCategoryFragment);
                }
                else
                {
                    transaction.show(mCategoryFragment);
                }
                break;
            case 3:
                setTextColor(textPerson, R.color.tab_text_selector);
                imagePerson.setImageResource(R.mipmap.tab_person_selected);
                if (mPersonCenterFragment == null)
                {
                    mPersonCenterFragment = new PersonCenterFragment();
                    transaction.add(R.id.content, mPersonCenterFragment);
                }
                else
                {
                    transaction.show(mPersonCenterFragment);
                }
                break;
                default:
                    break;
        }
        //提交事务
        transaction.commit();
    }

    //隐藏所有Fragment
    private void hideFragment(FragmentTransaction transaction)
    {
        if (mHomepageFragment != null)
        {
            transaction.hide(mHomepageFragment);
        }
        if (mKnowledgeFragment != null)
        {
            transaction.hide(mKnowledgeFragment);
        }
        if (mCategoryFragment != null)
        {
            transaction.hide(mCategoryFragment);
        }
        if (mPersonCenterFragment != null)
        {
            transaction.hide(mPersonCenterFragment);
        }
    }

    @OnClick({R.id.tab_homepage_layout, R.id.tab_knowledge_layout, R.id.tab_category_layout, R.id.tab_person_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_homepage_layout:
                setTabSelection(0);
                break;
            case R.id.tab_knowledge_layout:
                setTabSelection(1);
                break;
            case R.id.tab_category_layout:
                setTabSelection(2);
                break;
            case R.id.tab_person_layout:
                setTabSelection(3);
                break;
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection()
    {
        setTextColor(textHomepage, R.color.tab_text_normal);
        imageHomepage.setImageResource(R.mipmap.tab_homepage_normal);
        setTextColor(textKnowledge, R.color.tab_text_normal);
        imageKnowledge.setImageResource(R.mipmap.tab_knowledge_normal);
        setTextColor(textCategory, R.color.tab_text_normal);
        imageCategory.setImageResource(R.mipmap.tab_category_normal);
        setTextColor(textPerson, R.color.tab_text_normal);
        imagePerson.setImageResource(R.mipmap.tab_person_normal);
    }
}
