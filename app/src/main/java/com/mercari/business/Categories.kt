package com.mercari.business

import com.mercari.base.MercariBusiness

data class Categories(val all: List<Category>, val men: List<MenCategory>, val women: List<WomenCategory>) :
    MercariBusiness()