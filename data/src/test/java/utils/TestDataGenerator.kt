package utils

import com.dubizzle.data.model.ListingsData


class TestDataGenerator {
    companion object {
        fun generateListings(): List<ListingsData> {
            val l1 = ListingsData("4878bf592579410fba52941d00b62f94","AED 5","Notebook","2019-02-24 04:04:17.566515",
                listOf("9355183956e3445e89735d877b798689"), listOf("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4TX6UXWXL&Signature=hai1TXOsrCzIGYmfKTxp%2B7Va1kg%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEIj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIDZRT5f1eVF99fdTXwDsWLUQRLdQSviqIq4GI0UFh5asAiB5wfG06V8bXWKZMfgaSCQeLiYB%2BTYSpToA9Lu1q9QKWCqdAgiB%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDE4NDM5ODk2Njg0MSIMb0kHocMp2hT6uKFiKvEB%2F0jr%2BoinMgDeTcVHFBG7bfecK4hVkcj7qQLLsieAHDWKvNFX0rExKjfy29%2Bg%2B6YbuaWnRvienpl8kBdfhlB1I%2FRnPiiGuQVeAbaUnf8ffIOB%2BWUtHJkvGqCtQeg4wDY5F8l2%2BUdFVABDBoYHCyeXenMVMIdAeyO57H6CA0ZCz6juRe9Oj2Ep3oS%2F7cThQVYP87QIdfT0qN0Vd6R0rbWhSf83gDrI3Mp8Go1xou7MktuUgMks%2FwQiCezDZGypI0veXCQ4kA8BzYWsI7UxGac38DkNixsk%2FzNvoHpyGyYK3Mfnjip3yNsYEtwPnGRpO91L5TDf056OBjqbARwOXSvlAi%2BS1rzJBnf382CErKRuK4PN2Bo%2FxCAqMA0lS%2BdUX0lO6r9IJTn5FZTW6NP2%2BScjoLtSpvM4GiKNFguSkj6BwF4nzU0B8dmGtvePx1vezgNPNuMxBPHpOfmsxjocx5VR4eKQw2nsfUTg8NwGip4smHc0HC8Osx9mPnIBKPwlIMQIK40sji0W9Rrh%2BtGNa1nqV%2BC2uJeM&Expires=1640478705"),
                listOf("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689-thumbnail?AWSAccessKeyId=ASIASV3YI6A4TX6UXWXL&Signature=Dec70POeYwpDbQ9X80E6Z6MatuY%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEIj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIDZRT5f1eVF99fdTXwDsWLUQRLdQSviqIq4GI0UFh5asAiB5wfG06V8bXWKZMfgaSCQeLiYB%2BTYSpToA9Lu1q9QKWCqdAgiB%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDE4NDM5ODk2Njg0MSIMb0kHocMp2hT6uKFiKvEB%2F0jr%2BoinMgDeTcVHFBG7bfecK4hVkcj7qQLLsieAHDWKvNFX0rExKjfy29%2Bg%2B6YbuaWnRvienpl8kBdfhlB1I%2FRnPiiGuQVeAbaUnf8ffIOB%2BWUtHJkvGqCtQeg4wDY5F8l2%2BUdFVABDBoYHCyeXenMVMIdAeyO57H6CA0ZCz6juRe9Oj2Ep3oS%2F7cThQVYP87QIdfT0qN0Vd6R0rbWhSf83gDrI3Mp8Go1xou7MktuUgMks%2FwQiCezDZGypI0veXCQ4kA8BzYWsI7UxGac38DkNixsk%2FzNvoHpyGyYK3Mfnjip3yNsYEtwPnGRpO91L5TDf056OBjqbARwOXSvlAi%2BS1rzJBnf382CErKRuK4PN2Bo%2FxCAqMA0lS%2BdUX0lO6r9IJTn5FZTW6NP2%2BScjoLtSpvM4GiKNFguSkj6BwF4nzU0B8dmGtvePx1vezgNPNuMxBPHpOfmsxjocx5VR4eKQw2nsfUTg8NwGip4smHc0HC8Osx9mPnIBKPwlIMQIK40sji0W9Rrh%2BtGNa1nqV%2BC2uJeM&Expires=1640478705"))

            val l2 = ListingsData("bdf455e89f3b49f484d2a181b0268eab","AED 500","Glasses","2019-02-24 04:04:17.566515",
                listOf("9355183956e3445e89735d877b798689"), listOf("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4TX6UXWXL&Signature=hai1TXOsrCzIGYmfKTxp%2B7Va1kg%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEIj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIDZRT5f1eVF99fdTXwDsWLUQRLdQSviqIq4GI0UFh5asAiB5wfG06V8bXWKZMfgaSCQeLiYB%2BTYSpToA9Lu1q9QKWCqdAgiB%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDE4NDM5ODk2Njg0MSIMb0kHocMp2hT6uKFiKvEB%2F0jr%2BoinMgDeTcVHFBG7bfecK4hVkcj7qQLLsieAHDWKvNFX0rExKjfy29%2Bg%2B6YbuaWnRvienpl8kBdfhlB1I%2FRnPiiGuQVeAbaUnf8ffIOB%2BWUtHJkvGqCtQeg4wDY5F8l2%2BUdFVABDBoYHCyeXenMVMIdAeyO57H6CA0ZCz6juRe9Oj2Ep3oS%2F7cThQVYP87QIdfT0qN0Vd6R0rbWhSf83gDrI3Mp8Go1xou7MktuUgMks%2FwQiCezDZGypI0veXCQ4kA8BzYWsI7UxGac38DkNixsk%2FzNvoHpyGyYK3Mfnjip3yNsYEtwPnGRpO91L5TDf056OBjqbARwOXSvlAi%2BS1rzJBnf382CErKRuK4PN2Bo%2FxCAqMA0lS%2BdUX0lO6r9IJTn5FZTW6NP2%2BScjoLtSpvM4GiKNFguSkj6BwF4nzU0B8dmGtvePx1vezgNPNuMxBPHpOfmsxjocx5VR4eKQw2nsfUTg8NwGip4smHc0HC8Osx9mPnIBKPwlIMQIK40sji0W9Rrh%2BtGNa1nqV%2BC2uJeM&Expires=1640478705"),
                listOf("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689-thumbnail?AWSAccessKeyId=ASIASV3YI6A4TX6UXWXL&Signature=Dec70POeYwpDbQ9X80E6Z6MatuY%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEIj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIDZRT5f1eVF99fdTXwDsWLUQRLdQSviqIq4GI0UFh5asAiB5wfG06V8bXWKZMfgaSCQeLiYB%2BTYSpToA9Lu1q9QKWCqdAgiB%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDE4NDM5ODk2Njg0MSIMb0kHocMp2hT6uKFiKvEB%2F0jr%2BoinMgDeTcVHFBG7bfecK4hVkcj7qQLLsieAHDWKvNFX0rExKjfy29%2Bg%2B6YbuaWnRvienpl8kBdfhlB1I%2FRnPiiGuQVeAbaUnf8ffIOB%2BWUtHJkvGqCtQeg4wDY5F8l2%2BUdFVABDBoYHCyeXenMVMIdAeyO57H6CA0ZCz6juRe9Oj2Ep3oS%2F7cThQVYP87QIdfT0qN0Vd6R0rbWhSf83gDrI3Mp8Go1xou7MktuUgMks%2FwQiCezDZGypI0veXCQ4kA8BzYWsI7UxGac38DkNixsk%2FzNvoHpyGyYK3Mfnjip3yNsYEtwPnGRpO91L5TDf056OBjqbARwOXSvlAi%2BS1rzJBnf382CErKRuK4PN2Bo%2FxCAqMA0lS%2BdUX0lO6r9IJTn5FZTW6NP2%2BScjoLtSpvM4GiKNFguSkj6BwF4nzU0B8dmGtvePx1vezgNPNuMxBPHpOfmsxjocx5VR4eKQw2nsfUTg8NwGip4smHc0HC8Osx9mPnIBKPwlIMQIK40sji0W9Rrh%2BtGNa1nqV%2BC2uJeM&Expires=1640478705"))

            val l3 = ListingsData("b27233dd372543ffae38cce03ea9f047","AED 600","monitor","2019-02-27 11:21:59.983164",
                listOf("9355183956e3445e89735d877b798689"), listOf("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689?AWSAccessKeyId=ASIASV3YI6A4TX6UXWXL&Signature=hai1TXOsrCzIGYmfKTxp%2B7Va1kg%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEIj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIDZRT5f1eVF99fdTXwDsWLUQRLdQSviqIq4GI0UFh5asAiB5wfG06V8bXWKZMfgaSCQeLiYB%2BTYSpToA9Lu1q9QKWCqdAgiB%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDE4NDM5ODk2Njg0MSIMb0kHocMp2hT6uKFiKvEB%2F0jr%2BoinMgDeTcVHFBG7bfecK4hVkcj7qQLLsieAHDWKvNFX0rExKjfy29%2Bg%2B6YbuaWnRvienpl8kBdfhlB1I%2FRnPiiGuQVeAbaUnf8ffIOB%2BWUtHJkvGqCtQeg4wDY5F8l2%2BUdFVABDBoYHCyeXenMVMIdAeyO57H6CA0ZCz6juRe9Oj2Ep3oS%2F7cThQVYP87QIdfT0qN0Vd6R0rbWhSf83gDrI3Mp8Go1xou7MktuUgMks%2FwQiCezDZGypI0veXCQ4kA8BzYWsI7UxGac38DkNixsk%2FzNvoHpyGyYK3Mfnjip3yNsYEtwPnGRpO91L5TDf056OBjqbARwOXSvlAi%2BS1rzJBnf382CErKRuK4PN2Bo%2FxCAqMA0lS%2BdUX0lO6r9IJTn5FZTW6NP2%2BScjoLtSpvM4GiKNFguSkj6BwF4nzU0B8dmGtvePx1vezgNPNuMxBPHpOfmsxjocx5VR4eKQw2nsfUTg8NwGip4smHc0HC8Osx9mPnIBKPwlIMQIK40sji0W9Rrh%2BtGNa1nqV%2BC2uJeM&Expires=1640478705"),
                listOf("https://demo-app-photos-45687895456123.s3.amazonaws.com/9355183956e3445e89735d877b798689-thumbnail?AWSAccessKeyId=ASIASV3YI6A4TX6UXWXL&Signature=Dec70POeYwpDbQ9X80E6Z6MatuY%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEIj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIDZRT5f1eVF99fdTXwDsWLUQRLdQSviqIq4GI0UFh5asAiB5wfG06V8bXWKZMfgaSCQeLiYB%2BTYSpToA9Lu1q9QKWCqdAgiB%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDE4NDM5ODk2Njg0MSIMb0kHocMp2hT6uKFiKvEB%2F0jr%2BoinMgDeTcVHFBG7bfecK4hVkcj7qQLLsieAHDWKvNFX0rExKjfy29%2Bg%2B6YbuaWnRvienpl8kBdfhlB1I%2FRnPiiGuQVeAbaUnf8ffIOB%2BWUtHJkvGqCtQeg4wDY5F8l2%2BUdFVABDBoYHCyeXenMVMIdAeyO57H6CA0ZCz6juRe9Oj2Ep3oS%2F7cThQVYP87QIdfT0qN0Vd6R0rbWhSf83gDrI3Mp8Go1xou7MktuUgMks%2FwQiCezDZGypI0veXCQ4kA8BzYWsI7UxGac38DkNixsk%2FzNvoHpyGyYK3Mfnjip3yNsYEtwPnGRpO91L5TDf056OBjqbARwOXSvlAi%2BS1rzJBnf382CErKRuK4PN2Bo%2FxCAqMA0lS%2BdUX0lO6r9IJTn5FZTW6NP2%2BScjoLtSpvM4GiKNFguSkj6BwF4nzU0B8dmGtvePx1vezgNPNuMxBPHpOfmsxjocx5VR4eKQw2nsfUTg8NwGip4smHc0HC8Osx9mPnIBKPwlIMQIK40sji0W9Rrh%2BtGNa1nqV%2BC2uJeM&Expires=1640478705"))

            return listOf(l1, l2, l3)
        }
    }
}