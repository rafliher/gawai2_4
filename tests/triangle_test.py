import unittest
from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy

capabilities = dict(
    platformName='Android',
    automationName='uiautomator2',
    devicename='emulator-5554',
    appPackage='me.rafliher.gawai2_4',
    appActivity='me.rafliher.gawai2_4.MainActivity',
    language='en',
    locale='US',
    app="C:\\Users\\rafli\\AndroidStudioProjects\\gawai2_4\\app\\build\\intermediates\\apk\\debug\\app-debug.apk"
)

appium_server_url = 'http://localhost:4723'

class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Remote(appium_server_url, options=UiAutomator2Options().load_capabilities(capabilities))

    def tearDown(self):
        if self.driver:
            self.driver.quit()

    def test_triangle(self):
        self.driver.implicitly_wait(5)

        self.driver.find_element(by=AppiumBy.ID, value='me.rafliher.gawai2_4:id/buttonRectangle').click()

        txtPanjang = self.driver.find_element(by=AppiumBy.ID, value='me.rafliher.gawai2_4:id/txtPanjang')
        txtLebar = self.driver.find_element(by=AppiumBy.ID, value='me.rafliher.gawai2_4:id/txtLebar')
        txtHasil = self.driver.find_element(by=AppiumBy.ID, value='me.rafliher.gawai2_4:id/textView')
        button = self.driver.find_element(by=AppiumBy.ID, value='me.rafliher.gawai2_4:id/button')

        for i in range(1, 10):
            for j in range(1, 10):
                txtPanjang.clear()
                txtPanjang.send_keys(str(i))

                txtLebar.clear()
                txtLebar.send_keys(str(j))

                button.click()

                expected_result = '{:.1f}'.format((i * j) / 2)

                self.driver.implicitly_wait(2)
                actual_result = txtHasil.text

                self.assertEqual(expected_result, actual_result)

if __name__ == '__main__':
    unittest.main(verbosity=2, warnings='ignore')
